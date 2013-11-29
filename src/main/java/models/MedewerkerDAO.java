/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import org.apache.commons.codec.digest.DigestUtils;

import DBUtil.ConnectionMySQL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ChrisvanderHeijden
 */
public class MedewerkerDAO {
    private Medewerker tempMedewerker = null;
    ConnectionMySQL conn = new ConnectionMySQL();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private String user = "seanmoy58_hva";
    private String pw = "cWCl7Itb";
    private String url = "jdbc:mysql://seanmoy58.fiftyeight.axc.nl:3306/seanmoy58_hva?zeroDateTimeBehavior=convertToNull";

    public MedewerkerDAO() {
        // initialization 
    }

    public List<Medewerker> readAll() throws SQLException {
        List<Medewerker> list = new LinkedList<Medewerker>();
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT ID,NAME, STREETADDRESS, CITY FROM CUSTOMER";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Medewerker tempMedewerker;
//            tempMedewerker.setName(rs.getString("name"));
         //   tempMedewerker.setUsername(rs.getString("username"));
        //    tempMedewerker.setPassword(rs.DigestUtils.sha1Hex(String.valueOf("password")));
   //         tempMedewerker.setAppManager(rs.getBoolean("appManager"));
       //     list.add(tempMedewerker);
        }

        if (conn != null) {
            conn.closeConnection();
        }

        return list;
    }

    public Medewerker readById(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT ID,NAME, STREETADDRESS, CITY FROM CUSTOMER WHERE ID=?";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        prdstmt.setInt(1, id);

        rs = conn.performSelect(prdstmt);


        if (rs.next()) {
            
            tempMedewerker.setName(rs.getString("name"));
            tempMedewerker.setUsername(rs.getString("username"));
            tempMedewerker.setPassword(rs.getString("password"));
            tempMedewerker.setAppManager(rs.getBoolean("AppManager"));
        } else {
            return null;
        }

        if (conn != null) {
            conn.closeConnection();
        }


        return tempMedewerker;
    }

    public int create(Medewerker medewerker) throws SQLException {
        String query = "INSERT INTO `Users`  ( `userName`, `userRealName`, `userPass`, `userBeheer`, `userLang`) VALUES(?,?,?,?, NULL);";
        
        conn.startConnection();
        conn = (ConnectionMySQL) DriverManager.getConnection(url, user, pw);
        // some code needs to be writing
        //ps = conn.prepareStatement(query);
        ps.setString(1, medewerker.getUsername());
        ps.setString(2, medewerker.getName());
        ps.setString(3, medewerker.getPassword());
        ps.setBoolean(4,medewerker.isAppManager());
        //preparedStmt.setString(5, medewerker.getUserLang());
        ps.executeQuery();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public int update(Medewerker cust) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "UPDATE CUSTOMER SET  Name=?, StreetAddress=?,City=? ";
        query += " WHERE ID=?";

        conn.startConnection();
        // some code needs to be writing

        prdstmt.executeUpdate();

        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

    public int delete(Medewerker cust) throws SQLException {
        PreparedStatement prdstmt = null;
        String query = "DELETE  FROM CUSTOMER WHERE ID=?";

        conn.startConnection();
        // some code needs to be writing
        
        prdstmt.executeUpdate();


        if (conn != null) {
            conn.closeConnection();
        }
        return -1;
    }

}
