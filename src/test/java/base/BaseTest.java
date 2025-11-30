package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.LoginPage;
import page.MainPage;
import page.RegistrationPage;


public class BaseTest {

    //Объявили переменные
    public static WebDriver driver;// для управления браузером
    public static MainPage mainPage; // для главной страницы
    public static RegistrationPage registrationPage;// для регистрации
    public static LoginPage loginPage; // для авторизации

    @Before
    public void startUp() {

// выбор браузера на основании переменной, по умолчанию хром
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("yandex")) {
            driver = createYandexDriver();
        } else {
            driver = createChromeDriver();
        }
// инициализация
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        mainPage.openPage();
    }

    // методы запуска браузеров
    public WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Olesya/yandexdriver.exe");
        return new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}