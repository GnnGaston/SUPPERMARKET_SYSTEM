/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppermarket;

/**
 *
 * @author asha
 */
import javax.swing.*;
import java.sql.*;
public class DatabaseConnection {
    Connection conn;
    Statement st;
    ResultSet rs;
    
    public Connection ConnectDB(){
     String driver="com.mysql.jdbc.Driver";
     String user="root";
     String pasword="";
     String host="jdbc:mysql://localhost:3360/SupperMarketDB";
     
     try{
     Class.forName(driver);
      conn=DriverManager.getConnection(host, user, pasword);
     //JOptionPane.showMessageDialog(null, "successfully connected");
     }catch(Exception g){
     JOptionPane.showMessageDialog(null,"failed to connect  "+ g);
     
     }
    
    return conn;
    }
    
   
    
    
    
}
