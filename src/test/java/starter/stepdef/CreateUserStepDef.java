package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with invalid json {string}")
    public void postCreateUserWithInvalidJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY+ json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }
}
