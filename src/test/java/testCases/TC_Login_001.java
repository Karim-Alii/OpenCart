package testCases;


import com.sun.tools.attach.AttachOperationFailedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashBoard;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TC_Login_001 {
    WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
    DashBoard objDashBoard;



    @BeforeTest

    public void preCondition(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opencart.abstracta.us");

    }


    @Test(priority=0)

    public void test_Login_With_Valid_Credentials(){
        objLogin = new LoginPage(driver);
        objHomePage = new HomePage(driver);
        objDashBoard = new DashBoard(driver);
        objHomePage.goToMyAccount();
        objLogin.loginToOpenCart("karim9523@gmail.com","1234");


        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "My Account";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Assert passed");



    }




    @AfterTest

    public void postCondition(){
        objDashBoard.clickLogout();
        driver.quit();

    }




}
