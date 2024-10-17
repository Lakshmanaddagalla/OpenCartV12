package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class    BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String os,String br) throws IOException {

        //loading property file
        FileReader fi = new FileReader(".//src//main//resources//config.properties");
        p=new Properties();
        p.load(fi);

        logger= LogManager.getLogger(this.getClass());

        switch (br.toLowerCase()){
            case "chrome":driver= new ChromeDriver();break;
            case "edge":driver=new EdgeDriver();break;
            case "firefox":driver=new FirefoxDriver();break;
            default:System.out.println("Invalid browser name");return;

        }

        driver.manage().deleteAllCookies();
        driver.get(p.getProperty("appUrl"));//reading url from properties file
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;

    }

    public String randomNumber() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomAlphaNumeric() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return (generatedString + generatedNumber);

    }
}
