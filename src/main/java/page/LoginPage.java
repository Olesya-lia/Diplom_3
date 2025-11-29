package page;

import io.qameta.allure.Step;
import model.UserModelApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.time.Duration.ofSeconds;

public class LoginPage {

    private WebDriver driver;

    // Кнопка личный кабинет
    private final By personalCabinetBtn = By.xpath("//p[text() = 'Личный Кабинет']");
    // Поле email
    private final By fieldEmail = By.xpath("//label[text() = 'Email']/following-sibling::input");
    // Поле пароль
    private final By fieldPassword = By.xpath("//label[text() = 'Пароль']/following-sibling::input");
    // Кнопка войти
    private final By enterBtn = By.xpath("//button[text() = 'Войти']");
    // Имя в личном кабинете
    private final By valueLogin = By.xpath("//input[@class = 'text input__textfield text_type_main-default input__textfield-disabled']");
    // Кнопка войти на странице регистрации
    private final By enterRegisterBtn = By.xpath("//a[@class = 'Auth_link__1fOlj' and text()='Войти']");
    // Кнопка восстановить пароль
    private final By recoverPasswordBtn = By.xpath("//a[@class = 'Auth_link__1fOlj' and text()='Восстановить пароль']");

    // Конструктор для веб-драйвера
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalCabinetBtn(){
        driver.findElement(personalCabinetBtn).click();
    }

    @Step("Клик по кнопке Войти на странице регистрации")
    public void clickEnterPageRegisterBtn(){
        driver.findElement(enterRegisterBtn).click();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void clickRecoverPassword(){
        driver.findElement(recoverPasswordBtn).click();
    }

    @Step("Ввод email")
    public void setEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Клик по кнопке Войти на странице авторизации")
    public void clickEnterBtn(){
        driver.findElement(enterBtn).click();
    }

    @Step("Авторизации и вход")
    public void loginWithRegisteredUser(UserModelApi user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickEnterBtn();
    }

    @Step("Получение имени в личном кабинете для проверки успешной авторизации")
    public String getNameUserValue() {
        clickPersonalCabinetBtn();
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(valueLogin));
        String value = driver.findElement(valueLogin).getAttribute("value");
        return value;
    }
}
