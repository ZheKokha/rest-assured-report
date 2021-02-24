package steps;

import clients.GetUserClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.users.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetUserSteps {

    GetUserClient getUserClient = new GetUserClient();

    @When("a user retrieves the user information")
    public void aUserRetrievesTheBookByIsbn() {
        getUserClient.getUserResponse();
    }

    @Then("the response status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        assertEquals(getUserClient.getStatusCode(getUserClient.getUserResponse()), statusCode);
    }

    @And("response includes the following$")
    public void response_equals(Map<String, String> responseFields) {
        User[] user = getUserClient.getUser(getUserClient.getUserResponse());
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                assertEquals(user[0].name, Integer.parseInt(field.getValue()));
            } else {
                assertEquals(user[0].name, field.getValue());
            }

        }
    }
}
