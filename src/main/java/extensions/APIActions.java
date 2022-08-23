package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIActions extends CommonOps {



    @Step("Get Data From Server")
    public static Response get(String ParamValues){
        response= httpRequest.get(ParamValues);
        response.prettyPrint();
        return response;

    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path){
        jp= response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post Data From Server")
    public static void Post(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response= httpRequest.post(resource);
        response.prettyPrint();
    }
    @Step("Update Data From Server")
    public static void put(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response= httpRequest.put(resource);
        response.prettyPrint();

    }
    @Step("Delete Data From Server")
    public static void Delete(String id){

        response= httpRequest.delete("/student/"+id);
        response.prettyPrint();

    }
}
