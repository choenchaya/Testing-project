package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps{

    public static void OpenConnection(String dbURL,String user, String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(dbURL,user,pass);
            stmt=con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred While Connecting to DB, see Details: "+e);
        }
    }
    public static void CloseConnection(){

        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred While closing to DB, see Details: "+e);
        }
    }
}
