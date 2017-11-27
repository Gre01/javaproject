package Warzywniak;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Warzywniak.BD;

import javax.swing.*;


public class Main {


    public void addpanel(JFrame  pane) {
        
    	JTabbedPane Menu = new JTabbedPane();
    	
        Output fp = new Output();
        Menu.add(fp);
        
        pane.add(Menu, BorderLayout.CENTER);
        Menu.addTab("Warzywa", fp);
    }
 
    private static void Menu() {
      
        JFrame panel = new JFrame("Warzywniak");
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Main view = new Main();
        view.addpanel(panel);
      
        panel.pack();
        panel.setVisible(true);
    }
 
    public static void main(String[] args) {
    	BD era = new BD ();
        
        File f = new File("VegeBD.db");

        if(f.exists()){
            System.out.println("Jest juz baza danch VegeBD.db");
            
        }else{
            era.runz();  
            System.out.println("Stworzono baze danych VegeBD.db");
        }
  
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { Menu(); }
        });
    }

}