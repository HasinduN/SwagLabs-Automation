package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {
    WebDriver driver = null;

    By username = By.id("user-name");
    By password = By.id("password");
    By btn_login = By.id("login-button");
    By title_inventoryPage = By.className("app_logo");
    By error_msg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public LoginObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String text) {
        driver.findElement(username).sendKeys(text);
    }
    public void setPassword(String text){driver.findElement(password).sendKeys(text);}
    public void click_LoginBtn(){driver.findElement(btn_login).click();}

    public boolean isLoggedIn() {
        try{
            WebElement title = driver.findElement(title_inventoryPage);
            return title.isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }

    public boolean isLogginErorDisplayed() {
        try{
            WebElement error = driver.findElement(error_msg);
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
