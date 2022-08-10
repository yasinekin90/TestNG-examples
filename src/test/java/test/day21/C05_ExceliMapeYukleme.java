package test.day21;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class C05_ExceliMapeYukleme {

    @Test
    public void test01() throws IOException {
        String path = "src/test/java/resources/ulkeler.xlsx";
      String pageName="Sayfa1";
        Map<String,String>ulkelerMap=C03_ReusableMethodsExcel.createMap(path,pageName);
        //Mapi kullanarak "Cuba" bilgilerini yazdırınız..
        System.out.println("ulkelerMap.get(\"Cuba\") = " + ulkelerMap.get("Cuba"));

        //Listede "Fas" ın oldugunu test edin.
        Assert.assertTrue(ulkelerMap.containsKey("Nepal"));
    }
}
