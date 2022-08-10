package test.day21;

import com.google.common.hash.BloomFilter;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    // todo
    // Biz fis ile okuduğumuz excel dosyasını projemiz içerisinden kullanmak için
    // Apochi POI dependency yardımıyla bir Worbook oluşturduk.
    // Bu worbook sayesinde bir adet kopya oluşturup kullanıyoruz.
    // Excelin yapısı itibariyle hücreye ulaşmak için workbooktan başlayıp sheet ,row,cell ekadar gidip objeleri oluşturmamız lazım.

    @Test
    public void test01() throws IOException {
    String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(12);
        Cell cell=row.getCell(2);
        System.out.println("cell = " + cell);

         row=sheet.getRow(5);
        cell=row.getCell(2);
        String expected="Angola";

        System.out.println("cell1 = " + cell);
        Assert.assertTrue(cell.getStringCellValue().equals(expected));

        //kostarika yazdıralım
        row=sheet.getRow(40);
        cell=row.getCell(2);

        System.out.println("cell2 = " + cell);
    }
}
