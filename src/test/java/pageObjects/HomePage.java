package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    //1)Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //2)Locators

//span[normalize-space()='My Account']



    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement my_Account;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement login;
    //3)Action Methods

    public void clickMyAccount() {
        my_Account.click();
    }
    public void clickRegister() {
        register.click();
    }
     public void clickLogin(){
        login.click();
     }

}
