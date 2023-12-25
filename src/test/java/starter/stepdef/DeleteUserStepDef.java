package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Delete user with invalid {string}")
    public void deleteUserWithAlphabet(String id) {
        reqresAPI.deleteInUser(id);
    }

    @Given("Delete user with not found {int}")
    public void deleteUserWithNotFound(int id) {
        reqresAPI.deleteUser(id);
    }
}
