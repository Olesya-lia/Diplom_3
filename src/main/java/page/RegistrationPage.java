package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationUser {

    private WebDriver driver;

    // Локаторы

    // Кнопка личный кабинет
    private final By personalAccountBtn = By.xpath("//p[text() = 'Личный Кабинет']");
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
    public RegistrationUser(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAccountBtn(){
        driver.findElement(personalAccountBtn).click();
    }

    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }

    public void setName(String name){
        driver.findElement(fieldName).sendKeys(name);
    }

    public void setEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickRegisterBtn(){
        driver.findElement(registerBtn).click();
    }

    public void registerUser(String name, String email, String password){
        clickPersonalAccountBtn();
        clickRegisterLink();
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterBtn();
    }

    public WebElement getErrorPassword(){
        WebElement errorPassword = driver.findElement(errorMessagePassword);
        return errorPassword;
    }

    public boolean isOnLoginPage() {
        new WebDriverWait(driver, ofSeconds(6))
                .until(ExpectedConditions.urlContains("/login"));
        return driver.getCurrentUrl().contains("/login");
    }
}
