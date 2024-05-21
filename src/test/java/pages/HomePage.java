package pages;

import helper.Endpoint;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locator.HomeElements;

import java.awt.*;
import java.sql.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void goToHomePage(){
        driver.get(Endpoint.HOME_URL);
        System.out.println("success okeee");
    }


   public void clickMenu(String menu) throws InterruptedException {
        switch (menu){
            case "contact":
                driver.findElement(HomeElements.contactMenu).click();
                break;
            case "about us":
                driver.findElement(HomeElements.aboutUsMenu).click();
                break;
            case "cart":
                driver.findElement(HomeElements.cartMenu).click();
                break;
            case "login":
                driver.findElement(HomeElements.loginMenu).click();
                break;
            case "signup":
                driver.findElement(HomeElements.signUpMenu).click();
                break;
            case "phone":
                driver.findElement(HomeElements.phoneCategori).click();
                break;
            case "laptop":
                driver.findElement(HomeElements.laptopCategori).click();
                break;
            case "monitor":
                driver.findElement(HomeElements.monitorCategori).click();
                break;
            case "product":
                Thread.sleep(1000);
                driver.findElement(HomeElements.productLocation).click();
                break;
            case "add to cart":
                driver.findElement(HomeElements.addToCartButton).click();
                break;
            default:
                Assert.fail("menu not found");
        }
   }
    public void validateTitle(String title) throws InterruptedException {
        Thread.sleep(1000);
        assertTrue(driver.getPageSource().contains(title));
    }

    public void checkButton(String button) throws InterruptedException {
        Thread.sleep(500);
        assertTrue(driver.findElement(HomeElements.addToCartButton).isDisplayed());
    }
    public void validateAlert(String message) throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
        alert.accept();
    }
}
