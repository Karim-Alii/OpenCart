package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage {

    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a/i")
    WebElement shoppingCartBtn;

    @FindBy(xpath = "//div[@class=\"buttons clearfix\"]//div[@class= \"pull-right\"]")
    WebElement CheckoutBtn;



    String Page_URL = "https://opencart.abstracta.us/index.php?route=checkout/cart";

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void goToShoppingCart() {
        shoppingCartBtn.click();
    }

    public void clickCheckoutBtn() {
        CheckoutBtn.click();
    }

    public void emptyCart() {
        List<WebElement> Items = driver.findElements(By.xpath("//*[@class= \"fa fa-times-circle\"]"));
        for (WebElement i : Items) {
            i.click();

        }


        //button//i[@class="fa fa-times-circle"]

    }
    public void removeItemFromCart(String Item){

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]//a[text()=\""+Item+"\"]/ancestor::tr//following-sibling::td[4]//div//span//button[2]//i")).click();

    }

}
