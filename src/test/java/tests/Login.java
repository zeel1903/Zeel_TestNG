package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.NullPointerException;
public class Login {

    //WebDriver driver = null;

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginWithValid() {
        //WebDriver driver = null;
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
         driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(usernameInput.getAttribute("value"), "standard");
        Assert.assertEquals(passwordInput.getAttribute("value"), "secret_sauce");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager driver = null;
        if (driver != null) {
            driver.quit();
        }
    }
}


