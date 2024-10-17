package testCases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)// getting data from the DataProvider class
    public void verify_DDT(String email, String pwd, String exp) {

        logger.info("*****  Starting TC003_LoginDDT ");

        try {
            HomePage hm = new HomePage(driver);
            hm.clickMyAccount();
            hm.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLoginBtn();


            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExists();
            /*
Data is valid -- login success -- test passed
Data is valid -- login Failed -- test failed

Data is invalid -- login success -- test failed
Data is invalid -- login failed -- test passed
 */
            if (exp.equalsIgnoreCase("valid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("invalid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }


        logger.info("*****  Finished TC003_LoginDDT ***** ");
    }
}
