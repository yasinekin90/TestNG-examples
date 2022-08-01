package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    WebDriver driver;
    Select select;
    WebElement dropDown;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
         dropDown=driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropDown);

    }

    //todo
    // test01
    // https://www.amazon.com/ adresine gidin.
    //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    // Test 2
    // 1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test01(){

        List<WebElement> optionList=select.getOptions();
        Assert.assertEquals(optionList.size(),28,"Kategori sayısı eşit değil");

    }

    @Test
    public void test02(){

        select.selectByVisibleText("Books");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        //    2. Arama kutusuna Java yazin ve aratin
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Java", Keys.ENTER);

        WebElement result=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        System.out.println("result.getText() = " + result.getText());

        //    4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(result.getText().contains("Java"));

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
