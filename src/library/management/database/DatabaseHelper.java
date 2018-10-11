package library.management.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class DatabaseHelper {
    
    private static DatabaseHelper handler;
    
    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public DatabaseHelper(){
        createConnection();
    }

    void createConnection(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception ex) {
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
                stmt.execute("CREATE_TABLE" + TABLE_NAME + "("
                        +"id varchar(200) primary key,\n"
                        +"title varchar(200),\n"
                        +"author varchar(200),\n"
                        +"publisher varchar(200),\n"
                        +"intcode varchar(100),\n"
                        +"isAvail boolean default true"
                        +")");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + "--- setupDatabase");
        }finally{
            
        }
    }
}
