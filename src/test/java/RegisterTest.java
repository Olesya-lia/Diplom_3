import base.BaseTestUiUser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static data.TestData.*;
import static org.junit.Assert.assertTrue;

public class RegisterPageTest extends BaseTestUiUser {


    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация и переход на страницу авторизации")
    public void testSuccessRegisterUser() {
        registrationPage.goToTheRegistrationPage();
        registrationPage.setRegisterNewUser(NAME, EMAIL, PASSWORD);
        assertTrue("Не прошла регистрация",
                registrationPage.isOnLoginPage());
    }
}
