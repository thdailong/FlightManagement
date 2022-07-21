/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author truonglong
 */
public class ConnectDB {
    public static Connection connect() {
        try {
            String user = "sa";
            String pass = "0948516577";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HangMayBay";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            return connection;
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection con = new ConnectDB().connect();
        try {
            String sql = "Select * from Schedule";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("ID") + " " + rs.getString("TimeFrom"));
            }
        }
        catch (Exception e) {
            
        }
        
    }
}
