package homework13;

import com.google.gson.Gson;
import homework13.object.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestAssuredSwagger {

    public String baseUrl = "https://petstore.swagger.io/v2/";
    RequestSpecification requestSpesification = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .setContentType(ContentType.JSON)
            .build();

    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .build();

    @BeforeTest
    public void config()
    {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";

    }

    @Test
    public void firstRestAssuredTest()
    {
         given()
                 .spec(requestSpesification)
                 .basePath("/store/inventory")
         .when()
                 .get()
         .then()
                 .spec(responseSpecification);

    }

    @Test
    public void secondRestAssuredTest()
    {

        User user = new User();
        user.setId(1);
        user.setUsername("userUser");
        user.setFirstName("Octavian");
        user.setLastName("August");
        user.setEmail("email@test.com");
        user.setPassword("1111");
        user.setPhone("1112233");
        user.setUserStatus(1);

        String jsonObject = new Gson().toJson(user);


        given()
                .spec(requestSpesification)
                .body(jsonObject)


        .when()
                .post("/user")

        .then()
                .spec(responseSpecification);

    }

}
