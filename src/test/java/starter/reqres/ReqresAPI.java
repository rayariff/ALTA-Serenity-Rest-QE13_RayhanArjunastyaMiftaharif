package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String REGISTER_USER = Constants.BASE_URL+"/api/register";
    public static String LOGIN_USER = Constants.BASE_URL+"/api/login";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user 2")
    public void getSingleUser2(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update user")
    public void updateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Modify user")
    public void modifyUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Modify user invalid")
    public void modifyInUser(String id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete user with invalid id")
    public void deleteInUser(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post register new user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
