package pages.locator;

import org.openqa.selenium.By;

public class HomeElements {
    public static By contactMenu = By.xpath("//a[normalize-space()='Contact']");
    public static By aboutUsMenu = By.cssSelector("a[data-target='#videoModal']");
    public static By cartMenu = By.id("cartur");
    public static By loginMenu = By.id("login2");
    public static By signUpMenu = By.id("signin2");
    public static By phoneCategori = By.linkText("Phones");
    public static By laptopCategori = By.linkText("Laptops");
    public static By monitorCategori = By.linkText("Monitors");
    public static By productLocation = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    public static By addToCartButton = By.linkText("Add to cart");
}
