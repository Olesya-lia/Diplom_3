package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.MainPage;
import page.RegistrationPage;
import steps.UserStepsApi;

import static constants.Constants.STELLAR_BURGER;
import static data.TestData.*;
import static steps.UserStepsApi.deleteUser;

public class BaseTestUiUser {

    //Объявили переменные
    public static WebDriver driver;// для управления браузером
    public static MainPage mainPage; // для главной страницы
    public static RegistrationPage registrationPage; // для регистрации
//    private String accessToken;


    @Before
    public void startUp() {

        //RestAssured.baseURI = STELLAR_BURGER;
// выбор браузера на основании переменной, по умолчанию хром
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }
// инициализация
        registrationPage = new RegistrationPage(driver);
        mainPage = new MainPage(driver);
        mainPage.openPage();
    }

    // методы запуска браузеров
    public void startBrowserChrome(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }

    public void startBrowserFirefox(){
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void tearDown() {
        accessToken = UserStepsApi.loginUser(EMAIL, PASSWORD);
            if (accessToken != null) {
                deleteUser(accessToken);
            }
        driver.quit();
    }
}