package common;


import org.openqa.selenium.WebDriver;
import pages.LoginObjects;

public class CommonLogin {

    public void login(WebDriver driver, String un, String pw) {

        LoginObjects page = new LoginObjects(driver);

        page.setUsername(un);
        page.setPassword(pw);
        page.click_LoginBtn();
    }
}
