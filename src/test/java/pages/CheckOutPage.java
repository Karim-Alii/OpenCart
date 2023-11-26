package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckOutPage {

    WebDriver driver;


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //defining the variables that contain the elements of the "Billing details"

    @FindBy(xpath = "//*[text()=\"Step 2: Billing Details \"]")
    WebElement BillingDetailsSection;
    @FindBy(xpath = "//label//input[ @name = \"payment_address\"and @value= \"existing\"]")
    WebElement Billing_existing_address_RadioButton;

    @FindBy(xpath = "//div[@id = \"payment-existing\"]//select[@class=\"form-control\"]")
    WebElement Billing_existing_address_DropDown;

    @FindBy(xpath = "//label[\" I want to use a new address\"]//input[@value=\"new\"]")
    WebElement Billing_new_address_RadioButton;

    @FindBy(xpath = "//input[@id=\"input-payment-firstname\"]")
    WebElement Billing_new_address_FirstName_input;
    @FindBy(xpath = "//input[@id=\"input-payment-lastname\"]")
    WebElement Billing_new_address_LastName_input;
    @FindBy(xpath = "//input[@id=\"input-payment-company\"]")
    WebElement Billing_new_address_Company_input;
    @FindBy(xpath = "//input[@id=\"input-payment-address-1\"]")
    WebElement Billing_new_address_Address1_input;
    @FindBy(xpath = "//input[@id=\"input-payment-address-2\"]")
    WebElement Billing_new_address_Address2_input;
    @FindBy(xpath = "//input[@id=\"input-payment-city\"]")
    WebElement Billing_new_address_City_input;
    @FindBy(xpath = "//input[@id=\"input-payment-postcode\"]")
    WebElement Billing_new_address_PostCode_input;

    @FindBy(xpath = "//select[@id=\"input-payment-country\"]")
    WebElement Billing_existing_Country_DropDown;
    @FindBy(xpath = "//select[@id=\"input-payment-zone\"]")
    WebElement Billing_existing_Region_DropDown;

    @FindBy(xpath = "//div[@id = \"collapse-payment-address\"]//div//div[@class = \"buttons clearfix\"]//div[@class = \"pull-right\"]")
    WebElement BillingContinueBtn;


    public void FillBillingDetails(){
    String ClassValue = BillingDetailsSection.getAttribute("class");
    if(ClassValue.contains("collapsed") ){
       BillingDetailsSection.click();
    }
    Billing_existing_address_RadioButton.click();
    BillingContinueBtn.click();

    }













    //variable of delivery details section

    @FindBy(xpath = "//*[text()= \"Step 3: Delivery Details \"]")
    WebElement DeliveryDetailsSection;

    @FindBy(xpath = "//input[@name= \"shipping_address\" and @value =\"existing\"]")
    WebElement Delivery_existing_address_RadioButton;

    @FindBy(xpath = "//div[@id = \"shipping-existing\"]//select[@name= \"address_id\"]")
    WebElement Delivery_existing_address_DropDown;

    @FindBy(xpath = "//input[ @name = \"shipping_address\" and @value = \"new\"]")
    WebElement Delivery_new_address_RadioButton;

    @FindBy(xpath = "//input[@id=\"input-shipping-firstname\"]")
    WebElement Delivery_new_address_FirstName_input;
    @FindBy(xpath = "//input[@id=\"input-shipping-lastname\"]")
    WebElement Delivery_new_address_LastName_input;
    @FindBy(xpath = "//input[@id=\"input-shipping-company\"]")
    WebElement Delivery_new_address_Company_input;
    @FindBy(xpath = "//input[@id=\"input-shipping-address-1\"]")
    WebElement Delivery_new_address_Address1_input;
    @FindBy(xpath = "//input[@id=\"input-shipping-address-2\"]")
    WebElement Delivery_new_address_Address2_input;
    @FindBy(xpath = "//input[@id=\"input-shipping-city\"]")
    WebElement Delivery_new_address_City_input;
    @FindBy(xpath = "//input[@id=\"input-shipping-postcode\"]")
    WebElement Delivery_new_address_PostCode_input;
    @FindBy(xpath = "//select[@id=\"input-shipping-country\"]")
    WebElement Delivery_existing_Country_DropDown;
    @FindBy(xpath = "//select[@id=\"input-shipping-zone\"]")
    WebElement Delivery_existing_Region_DropDown;
    @FindBy(xpath = "//input[@id = \"button-shipping-address\"]")
    WebElement DeliveryDetailsContinueBtn;



    public void FillDeliveryDetails(){
        String ClassValue = DeliveryDetailsSection.getAttribute("class");
        if(ClassValue.contains("collapsed") ){
            DeliveryDetailsSection.click();
        }
        Delivery_existing_address_RadioButton.click();
        DeliveryDetailsContinueBtn.click();

    }









    //variable of delivery Method section

    @FindBy(xpath = "//*[text()=\"Step 4: Delivery Method \"]")
    WebElement DeliveryMethodSection;

    @FindBy(xpath = "//div[@id = \"collapse-shipping-method\"]//div//textarea[@name = \"comment\"]")
    WebElement Delivery_Method_comments;

    @FindBy(xpath = "//input[@id = \"button-shipping-method\"]")
    WebElement DeliveryMethodContinueBtn;




    public void FillDeliveryMethod(){
        String ClassValue = DeliveryMethodSection.getAttribute("class");
        if(ClassValue.contains("collapsed") ){
            DeliveryMethodSection.click();
        }

        Delivery_Method_comments.click();
        Delivery_Method_comments.sendKeys("that's a comment" );
        DeliveryMethodContinueBtn.click();
    }







    //variable of Payment Method section

    @FindBy(xpath = "//*[text()=\"Step 3: Payment Method \"]")
    WebElement PaymentMethodSection;

    @FindBy(xpath = "//*[text()=\"Step 5: Payment Method \"]")
    WebElement PaymentMethodLongFormSection;
    @FindBy(xpath = "//input[@name = \"payment_method\" and @value =\"bank_transfer\"]")
    WebElement Payment_Method_BankStatement_RadioButton;
    @FindBy(xpath = "//input[@name = \"payment_method\" and @value = \"cod\"]")
    WebElement Payment_Method_CashOnDelivery_RadioButton;

    @FindBy(xpath = "//div[@id = \"collapse-payment-method\"]//div//textarea[@name = \"comment\"]")
    WebElement Payment_Method_comments;

    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[3]/div/input[1]")
    WebElement Payment_Method_AgreeToTerms_CheckBox;

    @FindBy(xpath = "//*[@id  =\"button-payment-method\"]")
    WebElement PaymentMethodContinueBtn;







    public void FillPaymentMethod(){
        String ClassValue = PaymentMethodSection.getAttribute("class");
        if(ClassValue.contains("collapsed") ){
            PaymentMethodSection.click();
        }
        Payment_Method_BankStatement_RadioButton.click();
        Payment_Method_comments.click();
        Payment_Method_comments.sendKeys("some stuff");
        Payment_Method_AgreeToTerms_CheckBox.click();
        PaymentMethodContinueBtn.click();

    }

  public void FillPaymentLongMethod(){
        String ClassValue = PaymentMethodLongFormSection.getAttribute("class");
        if(ClassValue.contains("collapsed") ){
          PaymentMethodLongFormSection.click();
        }
        Payment_Method_BankStatement_RadioButton.click();
        Payment_Method_comments.click();
        Payment_Method_comments.sendKeys("some stuff");
        Payment_Method_AgreeToTerms_CheckBox.click();
       PaymentMethodContinueBtn.click();

    }



    @FindBy(xpath = "//input[@id = \"button-confirm\"]")
    WebElement ConfirmOrderBtn;

    public void ConfirmOrder(){


    ConfirmOrderBtn.click();


    }








    @FindBy(xpath = "//div[@id = \"bitnami-banner\"]")
    WebElement bitnamiBanner;

    @FindBy(xpath = "//img[@id = \"bitnami-close-banner-button\"]")
    WebElement bitnamiBanneriCloseButton;

    public void closeBanner(){
        if(bitnamiBanner.isDisplayed()){
            // Javascript executor to modify background color
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript ("document.getElementById('bitnami-close-banner-button').setAttribute('style', "
                    + "'display:block')");
            bitnamiBanneriCloseButton.click();

        }


    }



    @FindBy(xpath = "//div[@id = \"content\"]//p[text()= \"Your shopping cart is empty!\"]")
    WebElement ShoppingCartEmptyMessage;

    public boolean ShoppingCartIsEmpty(){
        if (ShoppingCartEmptyMessage.isDisplayed()){
            return true;
        }
        else {
            return false;
        }



    }

    public void AssertSuccess(){
        Assert.assertEquals(driver.getTitle() ,"Your order has been placed!");
    }
    public boolean longForm;
    public void isLongForm() {

        List<WebElement> Items = driver.findElements(By.className("panel panel-default"));
        if (Items.size() == 6) {
            longForm = true;
        } else {
            longForm = false;
        }

    }


}








