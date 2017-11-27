package Warzywniak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class CRUD{

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:VegeBD.db";
    private static Connection conn;
    private static Statement stmt;
	
	
    public Date StringToSQLDate(String str) {   
        return Date.valueOf(str);//converting string into sql date 
    }

    
    public void read(DefaultTableModel model) {
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        try {
 
            ResultSet result = stmt.executeQuery("SELECT * FROM Vege");
        
            Vege FULL =new Vege();
            
            while(result.next()) {
                
                FULL.setId_Vege(result.getInt("Id_Vege"));
                FULL.setName(result.getString("Name"));
                FULL.setPrice(result.getDouble("Price"));
                FULL.setDate(StringToSQLDate(result.getString("Date")));
                //FULL.setInstock(result.getInt("Instock"));
           
                //Object[] full = {FULL.getId_Vege(),FULL.getName(),FULL.getPrice(),FULL.getDate(),FULL.getInstock()};
                Object[] full = {FULL.getId_Vege(),FULL.getName(),FULL.getPrice(),FULL.getDate()};
                model.addRow(full); 
            }
            
        } catch (SQLException e){
            System.err.println("Blad przy wykonywaniu SELECT");
            e.printStackTrace();
        }

        try {
            stmt.close();
            
        } catch (SQLException e){
            System.err.println("SQLException");
            e.printStackTrace();
        }
	
    }

	
    public void delete(int id){
        
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            
        } catch (SQLException e){
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
	       
        Vege DELETE = new Vege();
        
        DELETE.setId_Vege(id);
        
        String sql =("DELETE FROM Vege WHERE Id_Vege = "+DELETE.getId_Vege());

        try {
            stmt.executeUpdate(sql);
            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();  
        }
    
        try {
            stmt.close();
  
        } catch (SQLException e) {
            System.err.println("SQLException");
            e.printStackTrace();
        }

    }
	

    //public int add(String Name, Double Price, Date Date, int Instock, JPanel inputPanel){
    public int add(String Name, Double Price, Date Date, JPanel inputPanel){
		
        int flag=0;
		
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
	        
            } catch (SQLException e) {
                System.err.println("Problem z otwarciem polaczenia");
                e.printStackTrace();
            }
		
            if(flag==0){
			
                //Vege ADD = new Vege(Name, Price, Date, Instock);
                Vege ADD = new Vege(Name, Price, Date);
		
                String sql = null;
                //sql=("INSERT INTO Vege (Name,Price,Date,Instock) VALUES ('"+ADD.getName()+"','"+ADD.getPrice()+"','"+ADD.getDate()+"','"+ADD.getInstock()+"')");
                sql=("INSERT INTO Vege (Name,Price,Date) VALUES ('"+ADD.getName()+"','"+ADD.getPrice()+"','"+ADD.getDate()+"')");
 
                try {
                    stmt.executeUpdate(sql);
                    
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(inputPanel, "Blad!"); 
                }
	
            }
        try {
            stmt.close();

        } catch (SQLException e) {
            System.err.println("SQLException");
            e.printStackTrace();
        }
	
        return flag;

	
    }
	
    
    //public int update(int id, String Name, Double Price, Date Date, int Instock, JPanel inputPanel){
    public int update(int id, String Name, Double Price, Date Date, JPanel inputPanel){
	String sql;
	
	int flag=0;
	
	try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
      
        if(flag==0){
	
            //Vege UPDATE = new Vege(id, Name, Price, Date, Instock);
            Vege UPDATE = new Vege(id, Name, Price, Date);
  
            //sql=("UPDATE Vege SET Name ='"+UPDATE.getName()+"',Price='"+UPDATE.getPrice()+"',Date='"+UPDATE.getDate()+"',Instock='"+UPDATE.getInstock()+"' WHERE Id_Vege="+UPDATE.getId_Vege());
            sql=("UPDATE Vege SET Name ='"+UPDATE.getName()+"',Price='"+UPDATE.getPrice()+"',Date='"+UPDATE.getDate()+"' WHERE Id_Vege="+UPDATE.getId_Vege());
	
            try {
            	stmt.executeUpdate(sql);
                
            } catch (SQLException e1) {
                flag=1;JOptionPane.showMessageDialog(inputPanel, "Blad!"); 
            }
				
        }
	
        try {
            stmt.close();

        } catch (SQLException e) {
            System.err.println("SQLException");
        }

    return flag;

    }
    
    public int findBN(String Name, JPanel inputPanel, DefaultTableModel model){
	
	
	int flag=0;
	
	try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
        
        try {
            
            ResultSet result = stmt.executeQuery("SELECT * FROM Vege WHERE Name='"+Name+"'");
            
            Vege FULL = new Vege();
            //if(result){ System.out.println("Jest juz baza danch VegeBD.db"); }
            while(result.next()) {
                
                FULL.setId_Vege(result.getInt("Id_Vege"));
                FULL.setName(result.getString("Name"));
                FULL.setPrice(result.getDouble("Price"));
                FULL.setDate(StringToSQLDate(result.getString("Date")));
                
                Object[] full = {FULL.getId_Vege(),FULL.getName(),FULL.getPrice(),FULL.getDate()};
                model.addRow(full); 
            }
            
        } catch (SQLException e){
            System.err.println("Blad przy wykonywaniu SELECT");
            e.printStackTrace();
        }

        try {
            stmt.close();
            
        } catch (SQLException e){
            System.err.println("SQLException");
            e.printStackTrace();
        }
    return flag;

    }
}