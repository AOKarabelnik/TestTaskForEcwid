package ru.ecwid;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FiltersTest {
    public static WebDriver driver;
    public static ProductPage productPage;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        productPage = new ProductPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("startpage"));
    }

    @Test
    public void filterCheck(){
        productPage.setMensCheckbox();

        productPage.setMediumCheckbox();

        productPage.checkCountFilter();

    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
