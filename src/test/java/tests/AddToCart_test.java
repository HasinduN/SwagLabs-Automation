package tests;

import common.CommonLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddToCart_objects;

public class AddToCart_test {

    private static WebDriver driver = null;

    @BeforeTest
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void addToCart() throws InterruptedException {

        CommonLogin login = new CommonLogin();
        login.login(driver, "standard_user", "secret_sauce");

        AddToCart_objects obj = new AddToCart_objects();
        Thread.sleep(3000);

        obj.AddToCart(driver);
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDownTest() {

        driver.close();
        driver.quit();
        System.out.println("Test completed");
    }
}
