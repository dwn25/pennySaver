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
    public static String mainAdvice = "";
    public static String tableName = "sql9303230";
    public static String dbName = "sql9303230";
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
    public static String message = " Welcome to the Main Menu\n" +
        "▸Budgetting Page : View your budget, get some advice and adjust your budget however you choose.\n" +
        "▸Savings Page: Calculate your savings forecast, view your current forecast and update it however you choose.\n" +
        "▸Stocks Page: View your current stock holdings.\n" +
        "▸Crypto Page: View your current crypto holdings.\n" +
        "▸Edit Info Page: Edit your basic information or delete account.\n" +
        "▸Logout: Logout and return to Login Page\n";
        
    public static void DoConnect1(){
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
    
     public static void DoConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/" + dbName;
            username="sql9303230";
            pwd="NxwMDZzAAU";
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