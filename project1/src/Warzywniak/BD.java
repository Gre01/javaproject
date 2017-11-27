package Warzywniak;

import java.sql.*;

public class BD{

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:VegeBD.db";
    
    private static Connection conn;
    private static Statement stmt;
    private static Statement stmq;
    
   
    public void runz(){

    	String sql;
 
        try {
            Class.forName(DRIVER);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            conn.setAutoCommit(false);
            stmq = conn.createStatement();
           
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
       
        //String CreateTable="CREATE TABLE IF NOT EXISTS Vege(Id_Vege INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(30),Price DOUBLE(4,2), Date DATE, Instock VARCHAR(6))";
        String CreateTable="CREATE TABLE IF NOT EXISTS Vege(Id_Vege INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(30),Price DOUBLE(4,2), Date DATE)";
        try {
            stmt.execute(CreateTable);

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli Vege");
            e.printStackTrace();
        } 
        
        try {
            sql="INSERT INTO Vege(Name,Price,Date) VALUES ('Ziemniak','1.00','2017-11-06');";
            stmt.execute(sql);
            
            sql="INSERT INTO Vege(Name,Price,Date) VALUES ('Cebula','2.00','2017-11-09');";
            stmt.execute(sql);
        
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu ucznia");
            e.printStackTrace();
        }        

        try {
            conn.commit();
            stmt.close();
            stmq.close();
            
        } catch (SQLException e) {
            System.err.println("SQLException");
            e.printStackTrace();
        }
      
        System.out.println("Stworzono VegeBD.db");
        
    }
}
