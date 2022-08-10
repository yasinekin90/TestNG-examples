package test.day21;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatirSayisi {
    //todo
    // ulkeler excelindeki Sayfa1 ve Sayfa2 deki satir sayilari
    // ve kullanılan satir sayilarini bulun

    @Test
    public void test01() throws IOException {
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

       int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();//burası index ile calısır
        int fizikselSatirNo=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();//index ile değil sayma sayısı ile çalısır
        System.out.println("satirSayisi = " + satirSayisi);//190
        System.out.println("fizikselSatirNo = " + fizikselSatirNo);//191

        int satirSayisi2=workbook.getSheet("Sayfa2").getLastRowNum();//burası index ile calısır
        int fizikselSatirNo2=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("satirSayisi2 = " + satirSayisi2);
        System.out.println("fizikselSatirNo 2= " + fizikselSatirNo2);
    }
}
