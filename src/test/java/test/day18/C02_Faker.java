package test.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Locale;

public class C02_Faker extends TestBase {
    //todo
    //   //"https://facebook.com/"  Adresine gidin
    //    //“create new account”  butonuna basin
    //    //“firstName” giris kutusuna bir isim yazin
    //    //“surname” giris kutusuna bir soyisim yazin
    //    //“email” giris kutusuna bir email yazin
    //    //“email” onay kutusuna emaili tekrar yazin
    //    //Bir sifre girin
    //    //Tarih icin gun secin
    //    //Tarih icin ay secin
    //    //Tarih icin yil secin
    //    //Cinsiyeti secin
    //    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //    //Sayfayi kapatin
    @Test
    public void facebook(){
        //   //"https://facebook.com/"  Adresine gidin
        driver.get("https://facebook.com/");
        //    //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[text()=\"Yeni Hesap Oluştur\"]")).click();
        //    //“firstName” giris kutusuna bir isim yazin
        WebElement firstName= driver.findElement(By.xpath("//input[@placeholder=\"Adın\"]"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        firstName.sendKeys(faker.name().firstName());
        actions.keyDown(Keys.TAB).sendKeys(faker.name().lastName())
                .keyDown(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .keyDown(Keys.TAB).sendKeys("123456789").perform();
//Tarih icin gun secin
        WebElement dropdown= driver.findElement(By.xpath("//select[@aria-label=\"Gün\"]"));
        Select select=new Select(dropdown);
        select.selectByValue("12");
        //Tarih icin ay secin
        WebElement dropdown2= driver.findElement(By.xpath("//select[@aria-label=\"Ay\"]"));
       select=new Select(dropdown2);
        select.selectByValue("8");
        //Tarih icin yil secin
        WebElement dropdown3= driver.findElement(By.xpath("//select[@aria-label=\"Yıl\"]"));
       select=new Select(dropdown3);
        select.selectByVisibleText("1990");
//    //Cinsiyeti secin
        WebElement radioButton=driver.findElement(By.xpath("//label[text()=\"Erkek\"]"));
        radioButton.click();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin
        Assert.assertTrue(radioButton.isEnabled(),"button secili değil");
        WebElement radioButton2=driver.findElement(By.xpath("//label[text()=\"Özel\"]"));
        Assert.assertFalse(radioButton2.isSelected(),"diğer button seçili");
    }
    @Test
    public void faker(){
        Faker faker=new Faker(new Locale("tr","TR"));//SECİLİRSE TÜRKCE FAKE ONERİLER VAR
        String str=faker.internet().avatar();
        System.out.println("str = " + str);


        str=faker.name().username().toLowerCase(Locale.ROOT);
        System.out.println("str = " + str);

        int int1=faker.number().randomDigit();

        System.out.println("int1 = " + int1);


        str=faker.phoneNumber().cellPhone();
        System.out.println("str = " + str);

        str=faker.address().fullAddress();
        System.out.println("str = " + str);




    }
}
