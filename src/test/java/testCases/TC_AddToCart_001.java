package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TC_AddToCart_001 {
    WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
    DashBoard objDashBoard;
    SearchPage objSearchPage;
    ItemPage objItemPage;

    Universal objUniversal;

    @BeforeTest

    public void preCondition(){

        driver = new ChromeDriver();
        objLogin = new LoginPage(driver);
        objHomePage = new HomePage(driver);
        objDashBoard = new DashBoard(driver);
        objSearchPage = new SearchPage(driver);
        objItemPage = new ItemPage(driver);
        objUniversal = new Universal(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage.goToHomePage();
        objHomePage.goToMyAccount();
        objLogin.loginToOpenCart("karim9523@gmail.com","1234");

    }



    @Test(priority=1)
    public void Add_Item_To_Cart(){

        objHomePage.goToHomePage();
        objHomePage.SearchAboutItem(Universal.SearchItem);
        objSearchPage.click_Searched_Item();
        objItemPage.Add_To_Cart(2);




    }

    @AfterTest

    public void postCondition(){
        objDashBoard.goToDashBoard();
        objDashBoard.clickLogout();
        driver.quit();

    }

}
