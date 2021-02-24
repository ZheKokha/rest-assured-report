package clients;

import io.restassured.response.Response;
import models.books.Book;

import static io.restassured.RestAssured.given;

public class GetBookClient extends AbstractClient{

    private final String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

/*    public void specifyRequest(String queryParam){
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .build().param("q", queryParam);
    }*/

    public Response getBookResponse(){
        return given()
                .param("q", "isbn:9781451648546")
                .when()
                .get(ENDPOINT_GET_BOOK_BY_ISBN)
                .thenReturn();
    }

    public Book getBook(Response response) {
        return response
                .then().extract().body().as(Book.class);
    }

}
