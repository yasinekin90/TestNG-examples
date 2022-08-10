package test.day21;

import org.apache.commons.math3.analysis.function.Ceil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReusableMethodsExcel {

    public static Cell cellCall(String path, String pageName, int rowIndex, int cellIndex)  {

        Cell cell=null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            cell = workbook.getSheet("Sayfa1").getRow(rowIndex).getCell(cellIndex);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cell;
    }
    public static Map<String,String> createMap(String path,String pageName){
        Map<String,String> excelMap=new TreeMap<>();
        Workbook workbook=null;
        //ilk adım excelden istenen sayfaya ulasmak

        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int satirSayisi=workbook.getSheet(pageName).getLastRowNum();
        String key="";
        String value="";
        for (int i=0;i<=satirSayisi;i++){
            //ikinci adımdatablodaki hücreleri mape uygun hale getirelim.
            key=workbook.getSheet(pageName).getRow(i).getCell(0).toString();
            value=workbook.getSheet(pageName).getRow(i).getCell(1).toString()+" "+
                    workbook.getSheet(pageName).getRow(i).getCell(2).toString()+" "+
                    workbook.getSheet(pageName).getRow(i).getCell(3).toString();
            excelMap.put(key,value);
        }
       return excelMap;

}}
