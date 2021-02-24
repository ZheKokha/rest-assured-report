package clients;

import io.restassured.response.Response;

import java.util.Map;

public abstract class AbstractClient {

    public Map getResponseMap(Response response) {
        return response
                .then().extract().body().as(Map.class);
    }

    public int getStatusCode(Response response){
        return response
                .then().extract().statusCode();
    }
}
