import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class API {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";


        String response1 =   given().log().all().when().get("/api/users/2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response1);

        String response2 =   given().log().all().body(BodyJson.patch()).when().patch("/api/users/2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response2);


        String response3 =   given().log().all().when().get("/api/users/2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response3);

        JsonPath jsl = new JsonPath(response3);
        String firstname = jsl.getString("data.first_name");
        System.out.println(firstname);
        String updatedfirstname = "john";
        Assert.assertEquals(firstname,updatedfirstname);

    }



}
