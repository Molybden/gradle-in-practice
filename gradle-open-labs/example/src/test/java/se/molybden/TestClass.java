package se.molybden;

import org.junit.Test;

public class TestClass {
    @Test
    public void testOneSecond(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){}
    }
    @Test
    public void testTwoSeconds(){
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
    }
}
