package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginObjects;

public class LoginTest {

    private static WebDriver driver = null;

    @Test(dataProvider = "cred")
    public void login(String scenario, String un, String pw) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        System.out.println("Running scenario: " + scenario + " with username: " + un + " and password: " + pw);

        driver.get("https://www.saucedemo.com/");

        LoginObjects page = new LoginObjects(driver);

        page.setUsername(un);

        page.setPassword(pw);

        page.click_LoginBtn();
        Thread.sleep(3000);

        if (scenario.equals("Both username and password correct")) {
            Assert.assertTrue(page.isLoggedIn(), "Login failed for valid credentials");
            System.out.println("Login successful for scenario: " + scenario);
        } else {
            Assert.assertTrue(page.isLogginErorDisplayed(), "Error msg not displayed for invalid credentials");
            System.out.println("Login failed as expected for scenario: " + scenario);
        }

        driver.quit();
        System.out.println("Test completed");
    }

    @DataProvider(name = "cred")
    public Object[][] getData() {
        return new Object[][] {
                {"Both username and password correct", "standard_user", "secret_sauce"},
                {"Only username is correct", "standard_user", "HAsindu"},
                {"Only password is correct", "Nana5689", "secret_sauce"},
                {"Both username and password wrong", "standard", "secret"}
        };
    }
}
