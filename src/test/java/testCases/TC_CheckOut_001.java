package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TC_CheckOut_001 {

    WebDriver driver;
    LoginPage objLogin;
    ShoppingCartPage objShoppingCartPage;
    HomePage objHomePage;
    DashBoard objDashBoard;
    SearchPage objSearchPage;
    ItemPage objItemPage;

    CheckOutPage objCheckOutPage;

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
        objShoppingCartPage = new ShoppingCartPage(driver);
        objCheckOutPage = new CheckOutPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage.goToHomePage();
        objHomePage.goToMyAccount();
        objLogin.loginToOpenCart("karim9523@gmail.com","1234");

        //remove all items from shopping cart
        objShoppingCartPage.goToShoppingCart();
        objShoppingCartPage.emptyCart();


    }

    @Test(priority=1)
    public void Add_Items_To_ShoppingCart_AND_CheckOut(){
        //adding items in the shopping list
        for ( String i: Universal.SearchedItems) {
            Universal.CurrentItem = i;
            objHomePage.goToHomePage();
            objHomePage.SearchAboutItem(Universal.CurrentItem);
            objSearchPage.click_Searched_Item();
            objItemPage.Add_To_Cart(1);
        }

        //going back to the homepage
        objHomePage.goToHomePage();
        //routing to the shopping cart page

        objShoppingCartPage.goToShoppingCart();


        driver.get("https://opencart.abstracta.us/index.php?route=checkout/checkout");

        objCheckOutPage.closeBanner();



        boolean longForm;
        List<WebElement> Items = driver.findElements(By.className("panel-default"));
        if (Items.size() == 6) {
            longForm = true;
        } else {
            longForm = false;
        }


        if (longForm == true) {

            objCheckOutPage.FillBillingDetails();

            objCheckOutPage.FillDeliveryDetails();

            objCheckOutPage.FillDeliveryMethod();

            objCheckOutPage.FillPaymentLongMethod();

            objCheckOutPage.ConfirmOrder();
        }
        else{

            objCheckOutPage.FillBillingDetails();

            // objCheckOutPage.FillDeliveryDetails();

            //   objCheckOutPage.FillDeliveryMethod();

            objCheckOutPage.FillPaymentMethod();

            objCheckOutPage.ConfirmOrder();

        }



        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.schedule(objCheckOutPage::AssertSuccess, 10, TimeUnit.SECONDS);







        //


    }


    @AfterTest

    public void postCondition(){
        driver.quit();

    }





}
