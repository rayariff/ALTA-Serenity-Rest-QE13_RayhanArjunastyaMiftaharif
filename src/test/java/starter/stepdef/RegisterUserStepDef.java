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

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Register user with valid {string}")
    public void registerUserWithAnd(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+ json);
        reqresAPI.postCreateUser(jsonRegisterUser);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Validate register user json schema {string}")
    public void validateRegisterUserJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //scenario 2
    @Given("Register with invalid {string}")
    public void registerWithInvalid(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+json);
        reqresAPI.postRegisterUser(jsonRegisterUser);
    }
}
