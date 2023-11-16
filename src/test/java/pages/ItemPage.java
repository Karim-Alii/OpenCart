package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id = \"input-quantity\"]")
    WebElement quantityField;

    @FindBy(xpath = "//button[text()=\"Add to Cart\"]")
    WebElement addToCartBtn;


    public ItemPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Add_To_Cart(int quantity){
        quantityField.clear();
        quantityField.sendKeys(Integer.toString(quantity));
        addToCartBtn.click();






    }


}
