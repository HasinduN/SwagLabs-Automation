package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart_objects {
    WebDriver driver = null;

    public void AddToCart(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        By[] AddToCartBtns = {
                By.id("add-to-cart-sauce-labs-backpack"),
                By.id("add-to-cart-sauce-labs-bike-light")
        };
        for(By button: AddToCartBtns) {
            WebElement addToCartBtn = driver.findElement(button);
            addToCartBtn.click();
            Thread.sleep(3000);
        }
    }


}
