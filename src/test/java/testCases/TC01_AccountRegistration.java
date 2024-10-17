package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC01_AccountRegistration extends BaseClass {



    @Test
    public void verify_Account_Registration()  {
        logger.info("*** I am starting TC01AccountRegistration ***");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicked on MyAccounts");
            homePage.clickRegister();
            logger.info("Clicked on Register");


            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            logger.info("Providing CustomerDetails");
            accountRegistrationPage.setFirstName(randomeString().toUpperCase());
            accountRegistrationPage.setLastName(randomeString().toUpperCase());
            accountRegistrationPage.setEmail(randomeString() + "@gmail.com");
            accountRegistrationPage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();


            accountRegistrationPage.setPassword(password);
            accountRegistrationPage.setConfirmPassword(password);
            accountRegistrationPage.clickAgree();
            accountRegistrationPage.clickContinue();
            String confMsg = accountRegistrationPage.getMessage();
            Assert.assertEquals(confMsg, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test Failed..");
            logger.debug("Debug logs..");
            Assert.fail();
        }
        logger.info("*** Finished TC01AccountRegistration ***");

    }


}

