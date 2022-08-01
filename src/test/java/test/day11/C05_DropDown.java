package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C05_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //amazona gidilsin 3. elementi seçip yazdıralım
    @Test
    public void thirdElement(){
        driver.get("https://www.amazon.com");
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);

        select.selectByIndex(3);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        select.selectByValue("search-alias=baby-products-intl-ship");
        System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Baby");
        System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());

        List<WebElement> optionList=select.getOptions();

        System.out.println("optionList.size() = " + optionList.size());
        for (WebElement each:optionList){

            System.out.println("each.getText() = " + each.getText());
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
