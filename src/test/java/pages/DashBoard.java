package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {


    private WebDriver driver;
    HomePage objHomePage =new HomePage(driver);

    private static String Page_URL = "https://opencart.abstracta.us/index.php?route=account/account";

    @FindBy(xpath = "//div//a[text()=\"Logout\" and @class=\"list-group-item\"]")
    WebElement Logout ;
    public DashBoard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToDashBoard(){
        driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[1]/a")).click();

    }
    public void clickLogout(){

        Logout.click();
    }

}
