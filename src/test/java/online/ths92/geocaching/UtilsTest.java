package online.ths92.geocaching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    private static final double DOUBLE_ASSERT_DELTA = 0.00000;

    @Test
    public void roundOff() {
        double a = 2.56;
        double b = 18.9653;

        double aResult = Utils.roundOff(a,1);
        double aExpected = 2.6;

        double bResult = Utils.roundOff(b,2);
        double bExpected = 18.97;

        assertEquals(aExpected,aResult, DOUBLE_ASSERT_DELTA);
        assertEquals(bExpected,bResult, DOUBLE_ASSERT_DELTA);
    }
}