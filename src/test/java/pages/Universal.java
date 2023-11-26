package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class Universal {
    WebDriver driver;
    public static String[] SearchedItems = new String[]{"MacBook","Samsung SyncMaster 941BW","iMac"};


    public static String CurrentItem;
    public static String itemToBeDeletedFromCart="iPhone";



    public Universal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }


    @FindBy(xpath = "//a//span[text()=\"Shopping Cart\"]")
   WebElement ShoppingCartBtn;



}
