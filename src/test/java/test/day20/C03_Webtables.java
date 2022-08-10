package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C03_Webtables extends TestBase {

    //todo
    // https://editor.datatables.net/
    //  /*     table() metodu oluşturun
    // ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
    // ○ Table’daki başlıkları(headers) konsolda yazdırın.
    // ● printRows() metodu oluşturun //tr
    // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
    // ● printCells() metodu oluşturun //td
    // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    // ● printColumns() metodu oluşturun
    // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    // ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    // ○ 5.column daki elementleri konsolda yazdırın.*/

    @Test
    public void table() throws InterruptedException {
        // ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);
       List<WebElement>tbody= driver.findElements(By.xpath("//td"));
        System.out.println("tbody.size() = " + tbody.size());
        // ○ Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement>thead=driver.findElements(By.xpath("//thead//th"));
        thead.stream().map(WebElement::getText).forEach(System.out::println);

    }

    // ● printRows() metodu oluşturun //tr
    @Test
    public void printRows() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);

        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement>trow=driver.findElements(By.xpath("//table//tr"));
        System.out.println("trow.size() = " + trow.size());
        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        trow.stream().map(WebElement::getText).forEach(System.out::println);
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("trow.get(4).getText() = " + trow.get(4).getText());

    }
    // ● printCells() metodu oluşturun
    @Test
    public void printCells() throws InterruptedException {
        // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);
        List<WebElement>tdatas= driver.findElements(By.xpath("//td"));
        // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        tdatas.stream().map(WebElement::getText).forEach(System.out::println);
    }

    // ● printColumns() metodu oluşturun
    @Test
    public void printColumns() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);

        // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> column= driver.findElements(By.xpath("//tr[6]//td"));
        System.out.println("column.size() = " + column.size());
        // ○ Table body’sinde bulunan sutunlardaki "office "kısmını  (column) konsolda yazdırın.
        List<WebElement> office= driver.findElements(By.xpath("//tbody//td[4]"));
        office.stream().map(WebElement::getText).forEach(System.out::println);
        // ○ 5.column daki elementleri konsolda yazdırın.*/
        List<WebElement> col5= driver.findElements(By.xpath("//tbody//td[5]"));
        col5.stream().map(WebElement::getText).forEach(System.out::println);
    }
}
