package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Universal {
    WebDriver driver;
   public static String SearchItem = "iPhone";


    public Universal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//a//span[text()=\"Shopping Cart\"]")
   WebElement ShoppingCartBtn;



}
