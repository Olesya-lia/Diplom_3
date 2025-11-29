import base.BaseTestApiUser;
import base.BaseTestUiUser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static data.TestData.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ParamIncorrectPasswordTest extends BaseTestUiUser {

    private String password;


    public ParamIncorrectPasswordTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters (name = "Неверный пароль {0}")
    public static Object [][] data(){
        return new Object[][]{
                {"1"},
                {"12"},
                {"1234"},
                {"12345"}
        };
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Создание пользователя с невалидным паролем менее 6 символов")
    public void createUserErrorPasswordTest() {
        registrationPage.goToTheRegistrationPage();
        registrationPage.setRegisterNewUser(NAME, EMAIL, password);
        assertTrue("Не появляется ошибка о неверном пароле",
                registrationPage.getErrorPassword().isDisplayed());
    }
}
