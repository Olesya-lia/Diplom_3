package page;

import model.ApiUserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class LoginUser {

    private WebDriver driver;

    // Кнопка личный кабинет
    private final By personalCabinetBtn = By.xpath("//p[text() = 'Личный Кабинет']");
    // Кнопка войти в аккаунт на главной странице
    private final By loginToTheAccountBtn = By.xpath("//button[text() = 'Войти в аккаунт']");
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


    public LoginUser(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalCabinetBtn(){
        driver.findElement(personalCabinetBtn).click();
    }

    public void clickLoginToTheAccountBtn(){
        driver.findElement(loginToTheAccountBtn).click();
    }

    public void clickEnterRegisterBtn(){
        driver.findElement(enterRegisterBtn).click();
    }

    public void setEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickEnterBtn(){
        driver.findElement(enterBtn).click();
    }

    public void loginWithRegisteredUser(ApiUserModel user){
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    public String getNameUserValue() {
        clickPersonalCabinetBtn();
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(valueLogin));
        String value = driver.findElement(valueLogin).getAttribute("value");
        return value;
    }
}
