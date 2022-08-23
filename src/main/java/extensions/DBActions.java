package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {


    @Step("Get Credentials From Database")
    public static List<String> getCredentials(String query){
        List<String> Credentials =new ArrayList<String>();
        try {
            rs =stmt.executeQuery(query);
            rs.next();
            Credentials.add(rs.getString(1));
            Credentials.add(rs.getString(2));
        } catch (Exception e) {
            System.out.println("Error Occurred While Printing Table Data, see Details: "+e);
        }
        return Credentials;
    }

}
