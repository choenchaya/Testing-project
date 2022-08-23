package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;
import java.util.Arrays;
import java.util.List;

public class APIFlows extends CommonOps {



    @Step("Business Flow: Get Student From List")
    public static String getStudentProperty(String jPath){
        Response response= APIActions.get("student/list");
        return APIActions.extractFromJSON(response, jPath);

    }
    @Step("Business Flow: Create String List Of Students API")
    public static List<String> listOfAPI(){
        Response response= APIActions.get("student/list");
        List <String> listFromAPI =Arrays.asList(response.asString().split("},"));
        return listFromAPI;

    }
    @Step("Business Flow: Create New Student In List")
    public static void PostStudent(String firstName, String lastName, String email, String programme){
        params.put("firstName",firstName);
        params.put("lastName",lastName);
        params.put("email",email);
        params.put("programme",programme);
        APIActions.Post(params,"/student/");

    }
    @Step("Business Flow: Update New Student In List")
    public static void UpdateStudent(String firstName, String lastName, String email, String programme, String id) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        APIActions.put(params,"/student/"+id);

    }
    @Step("Business Flow: Delete Student From The List")
    public static void DeleteStudent(String id) {
        APIActions.Delete(id);
    }
}
