package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashBoard;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TC_Login_002 {
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
    //Verify that the system doesn't accept invalid Email or Password
    public void test_Login_With_Invalid_Credentials(){
        objLogin = new LoginPage(driver);
        objHomePage = new HomePage(driver);
        objDashBoard = new DashBoard(driver);


        objHomePage.goToMyAccount();
        objLogin.loginToOpenCart("karim9523@gmail.com","123");

        WebElement alertBtn = driver.findElement(By.xpath("//div[@class =\"alert alert-danger alert-dismissible\" and text()= \" Warning: No match for E-Mail Address and/or Password.\"]"));
        Assert.assertEquals(true, alertBtn.isDisplayed());



        //String ActualTitle = driver.getTitle();
        //String ExpectedTitle = “”;
        //Assert.assertEquals(ActualTitle, ExpectedTitle);
        //System.out.println("Assert passed");

    }




    @AfterTest

    public void postCondition(){

        driver.quit();

    }

}
