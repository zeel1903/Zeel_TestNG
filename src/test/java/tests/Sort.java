package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import static org.apache.commons.lang3.ArrayUtils.isSorted;

public class Sort extends Login {
    private WebDriver driver;

    //@Test(priority = 1)
   // public void testDefaultSort(){
    //driver.findElement(By.className("product_sort_container")).click();
        //List<WebElement> productNames = driver.findElements(By.className("inventory_container"));
        //Assert.assertTrue(is Sorted(productNames));

    public void testProductSorting() {
        // Click on the sort dropdown
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        sortDropdown.click();

        // Get the list of product names before sorting
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        List<String> productNamesBeforeSorting = new ArrayList<>();
        for (WebElement productElement : productElements) {
            productNamesBeforeSorting.add(productElement.getText());
        }

        // Sort the product names using Collections.sort()
        Collections.sort(productNamesBeforeSorting);

        // Click on the "Name (A to Z)" option to sort products alphabetically
        WebElement sortOptionAZ = driver.findElement(By.xpath("//option[text()='Name (A to Z)']"));
        sortOptionAZ.click();

        // Get the list of product names after sorting
        List<WebElement> sortedProductElements = driver.findElements(By.className("inventory_item_name"));
        List<String> productNamesAfterSorting = new ArrayList<>();
        for (WebElement productElement : sortedProductElements) {
            productNamesAfterSorting.add(productElement.getText());
        }

        // Assert that the product names are sorted correctly
        Assert.assertEquals(productNamesAfterSorting, productNamesBeforeSorting);
    }

    }







