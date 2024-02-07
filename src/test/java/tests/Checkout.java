package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Checkout extends Login{
    private WebDriver driver;
    @BeforeClass
 public void setup() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
public void checkout_process() {
        loginWithValid();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));cartIcon.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));checkoutButton.click();
        WebElement firstNameInput = driver.findElement(By.id("first-name"));firstNameInput.sendKeys("John");
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Doe");
        WebElement finishbutton = driver.findElement(By.id("finish")); finishbutton.click();
    }
}


