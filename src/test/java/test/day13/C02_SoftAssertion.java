package test.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class C02_SoftAssertion {
    //todo
    // Yeni bir Class Olusturun : C03_SoftAssert
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Only Banking Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // //! 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin .


    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");

    }

    @Test
    public void test01(){

      driver.findElement(By.xpath("//button[@id=\"signin_button\"]")).click();
      driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("username");
      driver.findElement(By.xpath("//input[@id=\"user_password\"]")).sendKeys("password", Keys.ENTER);
      driver.navigate().back();
        // 6. Only Banking Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown=driver.findElement(By.xpath("//select[@id=\"pc_currency\"]"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(select.getFirstSelectedOption().isSelected(),"Basarılı sekilde seçilemedi");
        // //! 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin

        List<WebElement>dropDownList=select.getOptions();


        softAssert.assertTrue(dropDownList.stream().anyMatch(s -> s.getText().equals("Switzerlan (franc)")),"EŞLEŞME YOK");


      /*  for (WebElement each:dropDownList) {

            softAssert.assertTrue(each.getText().equals("Switzerland (franc)"));
            if(each.getText().equals("Switzerland (franc)")) {
                System.out.println("Aranan isim listede var");
                System.out.println("each.getText() = " + each.getText());
            }
        }
*/

        softAssert.assertAll();


    }

}
