package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {

    //todo
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin  ve yazdırın
    // Tüm dropdown değerleri(value) yazdırın
    // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
    // True , degilse False yazdırın.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown=driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
        Select select=new Select(dropDown);
        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın , 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByIndex(1);
        System.out.println("1.index = "+select.getFirstSelectedOption().getText());

        Thread.sleep(3000);

        select.selectByValue("2");
        System.out.println("2.value = "+select.getFirstSelectedOption().getText());

        // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin  ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("OPTİON1 = "+select.getFirstSelectedOption().getText());

        // Tüm dropdown değerleri(value) yazdırın
        List<WebElement> options=select.getOptions();
        for (WebElement option:options) {
            System.out.println("option = " + option.getText());
        }

        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
        // True , degilse False yazdırın.
        int actualdropSize=options.size();
        int expdropSize=3;

        Assert.assertEquals(actualdropSize,expdropSize,"option sayisi beklentileri karşılamadı");

    }
    @AfterMethod
    public void tearDown(){
       // driver.close();
    }
}
