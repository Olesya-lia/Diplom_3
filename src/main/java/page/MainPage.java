package page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constants.STELLAR_BURGER;
import static java.time.Duration.ofSeconds;

public class MainPage {

    private WebDriver driver;

    // Кнопка войти в аккаунт на главной странице
    private final By loginToTheAccountBtn = By.xpath("//button[text() = 'Войти в аккаунт']");
    // Булки
    private final By tabBun = By.xpath("//span[text()='Булки']");
    @Getter
    private final By choiceBun = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Булки']");
    // Соусы
    private final By tabSauces = By.xpath("//span[text()='Соусы']");
    @Getter
    private final By choiceSauces = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Соусы']");
    // Начинки
    private final By tabFillings = By.xpath("//span[text()='Начинки']");
    @Getter
    private final By choiceFillings = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Начинки']");

    // Конструктор для веб-драйвера
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открытие главной страницы
    public void openPage() {
        driver.get(STELLAR_BURGER);
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickLoginToTheAccountBtn(){
        driver.findElement(loginToTheAccountBtn).click();
    }

    @Step("Вкладка булки")
    public void clickTabBun(){
        driver.findElement(tabBun).click();
    }

    @Step("Вкладка соусы")
    public void clickTabSauces(){
        driver.findElement(tabSauces).click();
    }
    @Step("Вкладка начинки")
    public void clickTabFillings(){
        driver.findElement(tabFillings).click();
    }

    @Step("Проверяем выбранную вкладку")
    public boolean isVisibilityConstructorSelection(By tab){
        try {
            new WebDriverWait(driver, ofSeconds(6))
                    .until(ExpectedConditions.visibilityOfElementLocated(tab));
            driver.findElement(tab).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoAlertPresentException e){
            return false;
        }
    }
}
