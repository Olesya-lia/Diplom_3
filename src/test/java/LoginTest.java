import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import model.UserModelApi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.UserStepsApi;

import static constants.Constants.STELLAR_BURGER;
import static data.TestData.*;
import static org.junit.Assert.assertEquals;
import static steps.UserStepsApi.deleteUser;


public class LoginTest extends BaseTest {

    private String accessToken;
    public static UserModelApi testUser;

    @Before
    public void startUp() {
        super.startUp();
        RestAssured.baseURI = STELLAR_BURGER;
        testUser = new UserModelApi(EMAIL, NAME, PASSWORD);
        UserStepsApi.createUser(testUser);
    }

    @Test
    @DisplayName("Авторизация через личный кабинет")
    @Description("Проверка входа через личный кабинет")
    public void testAuthorizationBtnPersonalCabinet() {
        loginPage.clickPersonalCabinetBtn();
        loginPage.loginWithRegisteredUser(testUser);
        assertEquals("Вход не выполнен",
               testUser.getName(), loginPage.getNameUserValue());
    }

    @Test
    @DisplayName("Авторизация через кнопку Войти в аккаунт")
    @Description("Проверка входа через кнопку Войти в аккаунт на главной странице")
    public void testAuthorizationAccountBtn() {
        mainPage.clickLoginToTheAccountBtn();
        loginPage.loginWithRegisteredUser(testUser);
        assertEquals("Вход не выполнен",
                testUser.getName(), loginPage.getNameUserValue());
    }

    @Test
    @DisplayName("Авторизация через кнопку Войти на странице регистрации")
    @Description("Проверка входа через кнопку Войти на странице регистрации")
    public void testAuthorizationBtnEnterPageRegister() {
        registrationPage.goToTheRegistrationPage();
        loginPage.clickEnterPageRegisterBtn();
        loginPage.loginWithRegisteredUser(testUser);
        assertEquals("Вход не выполнен",
                testUser.getName(), loginPage.getNameUserValue());
    }

    @Test
    @DisplayName("Авторизация через кнопку Войти на странице восстановления пароля")
    @Description("Проверка входа через кнопку Войти на странице восстановления пароля")
    public void testAuthorizationBtnEnterPageRecoverPassword() {
        loginPage.clickPersonalCabinetBtn();
        loginPage.clickRecoverPassword();
        loginPage.clickEnterPageRegisterBtn();
        loginPage.loginWithRegisteredUser(testUser);
        assertEquals("Вход не выполнен",
                testUser.getName(), loginPage.getNameUserValue());
    }

    @After
    public void cleanUp() {
        accessToken = UserStepsApi.loginUser(testUser.getEmail(), testUser.getPassword());
        if (accessToken != null) {
            deleteUser(accessToken);
        }
       super.tearDown();
    }
}
