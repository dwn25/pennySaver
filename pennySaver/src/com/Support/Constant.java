package com.Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DNartey
 */
public class Constant {
    
    public static String alphaVantageAPIKey = "I58H97J6G9Y75TXB";
    public static String currentUser = "";
    public static String currentUserID = "";
    public static int IDS = 4;
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static String url;
    public static String pwd;
    public static String username;
    public static boolean hasStocks = false;
    public static boolean hasCrypto = false;
    public static boolean hasBudget = false;
    public static boolean hasSavings = false;

        
    public static void DoConnect(){
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url= "jdbc:derby://localhost:1527/pennySaverDatabase";
            username="root";
            pwd="password";
            con= DriverManager.getConnection(url, username, pwd);
            stmt=con.createStatement();
        }catch (SQLException err){
        System.out.println(err.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
  }
}
