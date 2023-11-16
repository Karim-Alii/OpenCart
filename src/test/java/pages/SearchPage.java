package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
        WebDriver driver;


    By searchedItem = By.xpath( "//div[@class= \"caption\"]//h4//a[text()=\""+Universal.SearchItem+"\"]");





    public SearchPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_Searched_Item(){
        driver.findElement(searchedItem).click();

    }



}
