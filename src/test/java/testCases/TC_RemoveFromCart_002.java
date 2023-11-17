package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TC_RemoveFromCart_002 {

    WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
    DashBoard objDashBoard;

    ShoppingCartPage objShoppingCartPage;
    @BeforeTest

    public void preCondition(){

        driver = new ChromeDriver();
        objLogin = new LoginPage(driver);
        objHomePage = new HomePage(driver);
        objDashBoard = new DashBoard(driver);
        objShoppingCartPage = new ShoppingCartPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage.goToHomePage();
        objHomePage.goToMyAccount();
        objLogin.loginToOpenCart("karim9523@gmail.com","1234");

    }
    @Test(priority = 2)
    public void Remove_All_Items(){
        //  driver.get("https://opencart.abstracta.us/index.php?route=checkout/cart");
        objShoppingCartPage.goToShoppingCart();
        objShoppingCartPage.removeItemFromCart(Universal.itemToBeDeletedFromCart);

    }

    @AfterTest

    public void postCondition(){
        driver.quit();

    }

}
