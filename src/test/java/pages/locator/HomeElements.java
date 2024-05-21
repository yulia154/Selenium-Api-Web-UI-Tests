package pages.locator;

import org.openqa.selenium.By;

public class HomeElements {
    public static By contactMenu = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    public static By aboutUsMenu = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    public static By cartMenu = By.id("cartur");
    public static By loginMenu = By.id("login2");
    public static By signUpMenu = By.id("signin2");
    public static By phoneCategori = By.xpath("/html/body/div[5]/div/div[1]/div/a[2]");
    public static By laptopCategori = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
    public static By monitorCategori = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");
    public static By productLocation = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    public static By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
}
