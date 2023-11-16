package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;


    @FindBy(xpath = "//input[@id =\"input-email\" ]")
    WebElement email;

    @FindBy(xpath = "//input[@id =\"input-password\" ]" )
    WebElement password;

    @FindBy(xpath = "//input[@value =\"Login\" ]")
    WebElement login ;

    @FindBy(xpath = "//title[text()= \"Account Login\"]")
    WebElement titleText;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoginTitle(){

        return    titleText.getText();

    }

    public void setEmail(String strEmail){

        email.sendKeys(strEmail);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

        password.sendKeys(strPassword);

    }
    public void clickLogin(){
        login.click();
    }

    public void loginToOpenCart(String strEmail,String strPassword){

        //Fill user name

        this.setEmail(strEmail);

        //Fill password

        this.setPassword(strPassword);

        //Click Login button

        this.clickLogin();
    }

}
