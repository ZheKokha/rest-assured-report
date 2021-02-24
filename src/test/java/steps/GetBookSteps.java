package steps;

import clients.GetBookClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetBookSteps {

    GetBookClient getBookClient = new GetBookClient();

    @When("a user retrieves the book by isbn with param")
    public void aUserRetrievesTheBookByIsbn() {
        getBookClient.getBookResponse();
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        assertEquals(getBookClient.getStatusCode(getBookClient.getBookResponse()), statusCode);
    }

    @And("response includes the following fields$")
    public void response_equals(Map<String, String> responseFields) {
        Map map = getBookClient.getResponseMap(getBookClient.getBookResponse());
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                assertEquals(map.get(field.getKey()), Integer.parseInt(field.getValue()));
            } else {
                assertEquals(map.get(field.getKey()), field.getValue());
            }
        }
    }
}
