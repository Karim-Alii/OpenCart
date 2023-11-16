package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private static String Page_URL = "https://opencart.abstracta.us/";

    @FindBy(xpath = "//li//a[text()=\"My Account\"]")
    WebElement myAccount ;

    @FindBy(xpath = "//input[@placeholder = \"Search\"]")
    WebElement SearchField;
    @FindBy(xpath = "//i[@class = \"fa fa-search\"]")
    WebElement SearchBtn;





    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void SearchAboutItem(String Item){

        SearchField.click();
        SearchField.sendKeys(Item);
        SearchBtn.click();



    }

    public void goToMyAccount(){

        myAccount.click();
    }
    public void goToHomePage(){
        driver.get(Page_URL);
    }
}
