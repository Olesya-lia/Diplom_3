import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.UserStepsApi;

import static constants.Constants.STELLAR_BURGER;
import static data.TestData.*;
import static org.junit.Assert.assertTrue;
import static steps.UserStepsApi.deleteUser;

public class RegisterTest extends BaseTest {

    private String accessToken;

    @Before
    public void startUp() {
        super.startUp();
        RestAssured.baseURI = STELLAR_BURGER;
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация и переход на страницу авторизации")
    public void testSuccessRegisterUser() {
        registrationPage.goToTheRegistrationPage();
        registrationPage.setRegisterNewUser(NAME, EMAIL, PASSWORD);
        assertTrue("Не прошла регистрация",
                registrationPage.isOnLoginPage());
    }

    @After
    public void cleanUp() {
        accessToken = UserStepsApi.loginUser(EMAIL, PASSWORD);
        if (accessToken != null) {
            deleteUser(accessToken);
        }
        super.tearDown();
    }
}
