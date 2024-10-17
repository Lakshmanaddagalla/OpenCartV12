package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//2)Locators

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailAddress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    //3)Action Methods

     public void setEmail(String email){
         txtEmailAddress.sendKeys(email);
     }

     public void setPassword(String password){
         txtPassword.sendKeys(password);
     }

     public void clickLoginBtn(){
         btnLogin.click();
     }


}

