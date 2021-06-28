package ru.ecwid;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "checkbox-category-20671018")
    private WebElement mensCheckbox;

    @FindBy(id = "checkbox-option-Size-Medium")
    private WebElement mediumCheckbox;



    public void setMensCheckbox() { this.mensCheckbox.click(); }

    public void setMediumCheckbox() {
//        Both options work strings 27 or 28-29 make the same
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('target','_self')", mediumCheckbox);
        this.mediumCheckbox.click();
    }


    public void checkCountFilter(){
        assert driver.findElement(By.xpath("//span[@class='ec-filters__applied-count']")).getText().equals("(2)");
    }
}
