package commercial.bankingapplication.Models;

import java.sql.*;

public class DatabaseDriver {
    private Connection conn;


    public DatabaseDriver(){
        // establish connection to the database
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:mazebank.db");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*
    * Client Section
    */
    public ResultSet getClientData(String pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='" + pAddress + "'AND Password='" +password + "';");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }



    /*
    Admin Section
     */
    public ResultSet getAdminData(String userName, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username= '" + userName + "' AND Password='" + password + "';");
        } catch(SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }


    /*
    * Utility Methods
    * */
}
