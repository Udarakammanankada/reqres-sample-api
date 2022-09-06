import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class API {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";


        String response2 =   given().log().all().get("/api/users/2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response2);

        String response3 =   given().log().all().body(BodyJson.patch()).patch("/api/users/2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response3);


        String response4 =   given().log().all().get("/api/users/2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response4);

    }



}
