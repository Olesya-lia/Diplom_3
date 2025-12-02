package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationPage {

    private WebDriver driver;

    // Локаторы

    // Кнопка личный кабинет
    private final By personalCabinetBtn = By.xpath("//p[text() = 'Личный Кабинет']");
    // Кнопка зарегистрироваться
    private final By registerLink = By.xpath("//a[@class = 'Auth_link__1fOlj' and text()='Зарегистрироваться']");
    // Поле Имя
    private final By fieldName = By.xpath("//label[text() = 'Имя']/following-sibling::input");
    // Поле email
    private final By fieldEmail = By.xpath("//label[text() = 'Email']/following-sibling::input");
    // Поле пароль
    private final By fieldPassword = By.xpath("//label[text() = 'Пароль']/following-sibling::input");
    // Кнопка зарегистрироваться
    private final By registerBtn = By.xpath("//button[text() = 'Зарегистрироваться']");
    // Сообщение об ошибке
    private final By errorMessagePassword = By.xpath("//p[text() = 'Некорректный пароль']");

    // Конструктор для веб-драйвера
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод имени")
    public void setName(String name){
        driver.findElement(fieldName).sendKeys(name);
    }

    @Step("Ввод почты")
    public void setEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Ввод пароль")
    public void setPassword(String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Переход на страницу регистрации")
    public void goToTheRegistrationPage() {
        driver.findElement(personalCabinetBtn).click();
        driver.findElement(registerLink).click();
    }

    @Step("Регистрация данных пользователя")
    public void setRegisterNewUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        driver.findElement(registerBtn).click();
    }

    @Step("Появление ошибки поля пароль при вводе менее 6 символов")
    public WebElement getErrorPassword(){
        WebElement errorPassword = driver.findElement(errorMessagePassword);
        return errorPassword;
    }

    @Step("Переход на URL /login при успешной регистрации")
    public boolean isOnLoginPage() {
        new WebDriverWait(driver, ofSeconds(6))
                .until(ExpectedConditions.urlContains("/login"));
        return driver.getCurrentUrl().contains("/login");
    }
}
