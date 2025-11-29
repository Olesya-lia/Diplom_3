import base.BaseTestApiUser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LoginPageTest extends BaseTestApiUser {

    @Test
    @DisplayName("Авторизация через личный кабинет")
    @Description("Проверка входа через личный кабинет")
    public void testAuthorizationBtnPersonalCabinet() {
        loginUser.clickPersonalCabinetBtn();
        loginUser.loginWithRegisteredUser(testUser);
        loginUser.clickEnterBtn();
        assertEquals("Вход не выполнен",
               testUser.getName(), loginUser.getNameUserValue());
    }

    @Test
    @DisplayName("Авторизация через кнопку Войти в аккаунт")
    @Description("Проверка входа через кнопку Войти в аккаунт на главной странице")
    public void testAuthorizationAccountBtn() {
        mainPage.clickLoginToTheAccountBtn();
        loginUser.loginWithRegisteredUser(testUser);
        loginUser.clickEnterBtn();
        assertEquals("Вход не выполнен",
                testUser.getName(), loginUser.getNameUserValue());
    }

    @Test
    @DisplayName("Авторизация через кнопку Войти на странице регистрации")
    @Description("Проверка входа через кнопку Войти на странице регистрации")
    public void testAuthorizationBtnEnterPageRegister() {
        registrationPage.goToTheRegistrationPage();
        loginUser.clickEnterRegisterBtn();
        loginUser.loginWithRegisteredUser(testUser);
        loginUser.clickEnterBtn();
        assertEquals("Вход не выполнен",
                testUser.getName(), loginUser.getNameUserValue());
    }

    @Test
    @DisplayName("Авторизация через кнопку Войти на странице восстановления пароля")
    @Description("Проверка входа через кнопку Войти на странице восстановления пароля")
    public void testAuthorizationBtnEnterPageRecoverPassword() {
        loginUser.clickPersonalCabinetBtn();
        loginUser.clickRecoverPassword();
        loginUser.clickEnterRegisterBtn();
        loginUser.loginWithRegisteredUser(testUser);
        loginUser.clickEnterBtn();
        assertEquals("Вход не выполнен",
                testUser.getName(), loginUser.getNameUserValue());
    }
}
