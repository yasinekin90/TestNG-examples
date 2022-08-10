package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class C02_JsExecutorScrollViewIn extends TestBase {
    //todo
    // 1- Yeni bir class olusturun : ScroolInto
    // 2- /movita.com gidin
    // 3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki
    // 4- istediginiz çözümler sayfasi acildigini test edin

    @Test
    public void actionsclass(){
        driver.get("https://www.movita.com.tr");
        WebElement click=driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(click);
        click.click();
    }
    @Test
    public void jsMethod() throws InterruptedException {
        driver.get("https://www.movita.com.tr");
        WebElement cozum=driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",cozum);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click()",cozum);
        // 4- istediginiz çözümler sayfasi acildigini test edin
        List<WebElement>cozumtext=driver.findElements(By.tagName("h3"));
        System.out.println("cozumtext = " + cozumtext);

        for (WebElement each:cozumtext) {
            System.out.println("each.getText() = " + each.getText());
        }

        Assert.assertTrue(cozumtext.size()>=4);

    }
}
