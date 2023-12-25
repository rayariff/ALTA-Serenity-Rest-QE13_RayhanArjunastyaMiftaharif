package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //scneario 1
    @Given("Login user with valid {string}")
    public void loginUserWithValid(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY+ json);
        reqresAPI.postLoginUser(jsonLoginUser);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when()
                .post(ReqresAPI.LOGIN_USER);
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //scenario 2
    @Given("Login user with invalid {string}")
    public void loginUserWithInvalid(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY+ json);
        reqresAPI.postLoginUser(jsonLoginUser);
    }
}
