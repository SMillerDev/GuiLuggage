package DBUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ahmed
 */
public class ConnectionMySQL {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://seanmoy58.fiftyeight.axc.nl/seanmoy58_hva";
    public static final String DBUSER = "seanmoy58_hva";
    public static final String DBPASS = "cWCl7Itb";

    private ResultSet result = null;
    private int affectedRows = -1;
    Connection conn = null;

    
    public ConnectionMySQL() {
    }

    public void startConnection()  {
        try {
            
            Class.forName(DRIVER);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            
        } catch (Exception e) {
            
           
        }
    }

    public void closeConnection()  {
       try{
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
       } catch (Exception e) {
                       
        }
        conn = null;
    }

    public ResultSet performSelect(PreparedStatement prdstmt) throws SQLException {       
            result = prdstmt.executeQuery();
        
        return result;
    }

    public int performUpdate(PreparedStatement prdstmt) throws SQLException {
        
            affectedRows = prdstmt.executeUpdate();
       
        return affectedRows;
    }

    public Connection getConnection() {
        return conn;
    }
    
    
}
