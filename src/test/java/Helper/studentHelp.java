package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class studentHelp {

    RequestSpecification httpRequest;
    Response response;
    String url= "http://localhost:9000/";

    @Test
    public void testingAPI (){
        RestAssured.baseURI =url;
        httpRequest =RestAssured.given();


        //Get

       response= httpRequest.get("/student/list");

        //post
        //JSONObject params =new JSONObject();
        //params.put("firstName","Moshe");
       // params.put("lastName","Choen");
        //params.put("email","MOSHCHOEN04@gmail.com");
        //params.put("programme","Financial Analysis");

        //httpRequest.header("content-type","application/json");
        //httpRequest.body(params.toJSONString());
       // response= httpRequest.post("/student/list");
       // response= httpRequest.put("/student/list/101");
       // response= httpRequest.delete("/student/");

        response.prettyPrint();




    }



}
