package Warzywniak;


import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;


import Warzywniak.CRUD;
import java.sql.Date;


public class Output extends JPanel{

    private static final long serialVersionUID = 1L;

    CRUD a = new CRUD();
    private DefaultTableModel model;
    private JPanel inputPanel = new JPanel();	
    private JTable table;
    private JLabel NazwaLabel; 
    private JLabel CenaLabel; 
    private JLabel TerminLabel; 
    //private JLabel magazynLabel; 
    private JTextField  Cena;
    private JTextField  Nazwa;
    private JTextField  Termin;
    //private JTextField  magazyn;
    

    public Date StringToSQLDate(String str) {   
        return Date.valueOf(str);//converting string into sql date 
    }
    

    public Output() {
        super();
        model = new DefaultTableModel(){
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        
        
        model.addColumn("Id Klient");
        model.addColumn("Nazwa");
        model.addColumn("Cena");
        model.addColumn("Termin waz.");
        //model.addColumn("W magazynie");
        
        a.read(model);
    
        table = new JTable(model);
        table.removeColumn(table.getColumnModel().getColumn(0));

    
        //JTextfields   
        Nazwa= new JTextField(15);
        Cena= new JTextField(10);
        Termin= new JTextField(15);
        //magazyn= new JTextField(10);
        //JLabels
        NazwaLabel = new JLabel("Nazwa");
        CenaLabel = new JLabel("Cena");
        TerminLabel = new JLabel("Termin waz.");
        //magazynLabel = new JLabel("W magazynie");

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if (e.getClickCount() == 2) {
                    Nazwa.setText((String)(table.getModel().getValueAt(table.getSelectedRow(),1)));
                }
            }
        });  

        
        
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                int id;
                //id=a.add(Nazwa.getText(),Double.parseDouble(Cena.getText()),StringToSQLDate(Termin.getText()), Integer.valueOf(magazyn.getText()),inputPanel);
                id=a.add(Nazwa.getText(),Double.parseDouble(Cena.getText()),StringToSQLDate(Termin.getText()),inputPanel);

                if(id!=-1) {setmodel(); }
            }
        });

        JButton removeButton = new JButton("Delete");
        removeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(inputPanel, "Kliknij na rekord ktory chcesz usunac");

                }else{

                    int value = (int) (table.getModel().getValueAt(table.getSelectedRow(),0));

                    int answer = JOptionPane.showConfirmDialog(
                        inputPanel,
                        "Jestes pewien ze chcesz usunac ten rekord?",
                        "WARNING",
                        JOptionPane.YES_NO_OPTION);

                    if(answer == JOptionPane.YES_OPTION){
                        a.delete(value);
                        model.removeRow(table.getSelectedRow());
                    }

                }
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                int row = table.getSelectedRow();  
                if(row == -1) {
                    JOptionPane.showMessageDialog(inputPanel, "Kliknij na rekord ktory chcesz zaktualizowac");

                }else{

                    int id=0;

                    int value = (int) (table.getModel().getValueAt(row,0));
                    //id=a.update(value,Nazwa.getText(),Double.parseDouble(Cena.getText()), StringToSQLDate(Termin.getText()), Integer.valueOf(magazyn.getText()),inputPanel);
                    id=a.update(value,Nazwa.getText(),Double.parseDouble(Cena.getText()), StringToSQLDate(Termin.getText()), inputPanel);

                    if(id!=-1) { setmodel(); }
                }
            }
        });
        
        JButton findBNButton = new JButton("Find by Name");
        findBNButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                
                int id=0;

                //int value = (int) (table.getModel().getValueAt(row,0));
                id=a.findBN(Nazwa.getText(), inputPanel, model);

                if(id!=-1) { setmodel(); }
                
            }
        });
        inputPanel.setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();


        JScrollPane tableContainer = new JScrollPane(table);

        inputPanel.add(tableContainer, BorderLayout.CENTER);
        subPanel.add(addButton);
        subPanel.add(removeButton);


        subPanel.add(updateButton);

        subPanel.add(NazwaLabel);
        subPanel.add(Nazwa);
        subPanel.add(CenaLabel);
        subPanel.add(Cena);
        subPanel.add(TerminLabel);
        subPanel.add(Termin);
        //subPanel.add(magazynLabel);
        //subPanel.add(magazyn);

        subPanel.add(findBNButton);
        
        
        inputPanel.add(subPanel, BorderLayout.NORTH);

        add(inputPanel);

    }

    void  setmodel(){
		
        this.model = new DefaultTableModel(){

            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) { return false; }

        };

        model.addColumn("Id Vege");
        model.addColumn("Nazwa");
        model.addColumn("Cena");
        model.addColumn("Termin waz.");
        //model.addColumn("W magazynie");

        a.read(model);
        this.table.setModel(model);
        table.removeColumn(table.getColumnModel().getColumn(0));

    }
}