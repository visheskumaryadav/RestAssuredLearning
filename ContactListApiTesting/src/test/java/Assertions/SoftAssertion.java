package Assertions;

import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    private static SoftAssert assertion;


    public static SoftAssert SetUp(){
        if(assertion==null){
            assertion=new SoftAssert();
        }
        return assertion;
    }
}
