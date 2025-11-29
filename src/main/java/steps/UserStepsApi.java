package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ApiUserModel;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class ApiUserSteps {

    @Step("Создание пользователя")
    public static Response createUser(ApiUserModel userModel){
        return given()
                .contentType(ContentType.JSON)
                .body(userModel)
                .when()
                .post(CREATE_USER_PATH)
                .then()
                .extract().response();
    }

    @Step("Авторизация пользователя и получение токена")
    public static String loginUser(String email, String password) {
        ApiUserModel user = new ApiUserModel(email,password);
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(LOGIN_USER_PATH)
                .then()
                .log().all()
                .extract().response();
        return response.jsonPath().getString("accessToken");
    }

    @Step("Удаление пользователя c помощью token")
    public static Response deleteUser(String token) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .delete(DELETE_USER_PATH)
                .then()
                .log().all()
                .extract().response();
    }
}
