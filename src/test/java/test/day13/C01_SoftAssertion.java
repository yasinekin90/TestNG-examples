package test.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C01_SoftAssertion {
    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(a>b,"1.test başarısız");       //OUTPUTS
        softAssert.assertTrue(a>c,"2.test başarısız");   /*1.test başarısız expected [true] but found [false],
	                                                                       2.test başarısız expected [true] but found [false],
	                                                                       5.test başarısız expected [true] but found [false]*/
        softAssert.assertTrue(b>a,"3.test başarısız");
        softAssert.assertTrue(c>a,"4.test başarısız");
        softAssert.assertTrue(b>c,"5.test başarısız");

        softAssert.assertAll();
     }
}
