package library.management.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public final class DatabaseHelper {
    
    private static DatabaseHelper handler;
    
    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public DatabaseHelper(){
        createConnection();
        setupBookTable();
        
        
    }

    void createConnection(){
        try {
            Object newInstance = Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    void setupBookTable(){
        String TABLE_NAME = "BOOK";
        try {
            stmt = conn.createStatement();
            
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()){
                System.out.println("Table" + TABLE_NAME + "already exists. Ready for go!");
            }else{
                stmt.execute("CREATE TABLE" + TABLE_NAME + "("
                        +" id varchar(200) primary_key,\n"
                        +" title varchar(200),\n"
                        +" author varchar(200),\n"
                        +" publisher varchar(200),\n"
                        +" isAvail boolean default true"
                        +")");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        }finally{
        }
    }
    
    public ResultSet execQuery(String query){
        ResultSet result;
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Exception at execQuery:dataHandler" + e.getLocalizedMessage());
            return null;
        }finally{
        }
        return result;
    }
    
    public boolean execAction(String qu){
        try{
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return false;
        }finally{
    }
}
}
