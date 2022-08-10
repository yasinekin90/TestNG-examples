package test.day21;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {

    @Test
    public void test(){
        String path = "src/test/java/resources/ulkeler.xlsx";
        String expected="Azerbaycan";
        String actual=C03_ReusableMethodsExcel.cellCall(path,"Sayfa1",11,2).toString();
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual,expected,"test failed");
    }



}
