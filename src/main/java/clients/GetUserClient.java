package clients;

import io.restassured.response.Response;
import models.users.User;

import static io.restassured.RestAssured.given;

public class GetUserClient extends AbstractClient{

    private final String ENDPOINT_JSON = "http://jsonplaceholder.typicode.com/";

    public Response getUserResponse(){
        return given().baseUri(ENDPOINT_JSON)
                .when()
                .get("users")
                .thenReturn();
    }

    public User[] getUser(Response response) {
        return response
                .then().extract().body().as(User[].class);
    }

}
