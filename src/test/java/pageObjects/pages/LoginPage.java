package pageObjects.pages;

import controllers.BaseMethod;
import controllers.InitMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BaseMethod {

    @FindBy(id = "login_id")
    public WebElement txtUsername;

    @FindBy(id = "login_pass")
    public WebElement txtPwd;

    @FindBy(id = "login_btn")
    public WebElement btnLogin;

    @FindBy(linkText = "ホーム")
    public WebElement txtHome;

    public LoginPage login(String username, String pass){
        assertIsDisplayed(txtUsername, InitMethod.SLEEP_1000_MS);
        clearAndType(txtUsername, username);
        assertIsDisplayed(txtPwd, InitMethod.SLEEP_1000_MS);
        clearAndType(txtPwd, pass);
        assertIsDisplayed(btnLogin, InitMethod.SLEEP_1000_MS);
        click(btnLogin);
        Assert.assertEquals(txtHome.isDisplayed(), true);
        return this;
    }
}
