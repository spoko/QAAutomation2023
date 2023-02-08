package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    protected WebDriver driver;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
