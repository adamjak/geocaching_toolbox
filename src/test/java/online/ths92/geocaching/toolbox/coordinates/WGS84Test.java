package online.ths92.geocaching.toolbox.coordinates;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WGS84Test {
    public static final double TEST_X = 48.75495;
    public static final double TEST_Y = 019.11515;

    // N48.75495° E019.11515°
    // N48° 45.297' E019° 06.909'
    // N48° 45' 17.820'' E019° 06' 54.540''

    private WGS84 format;

    @Before
    public void setUp() throws Exception {
        this.format = new WGS84(TEST_X, TEST_Y);
    }

    @Test
    public void getXAndY() {
        assertEquals(TEST_X, this.format.getX(),0.00000000);
        assertEquals(TEST_Y, this.format.getY(), 0.00000000);
    }

    @Test
    public void getXInDecimalDegrees() {
        assertEquals("N 48.75495", this.format.getXInDecimalDegrees());
    }

    @Test
    public void getYInDecimalDegrees() {
        assertEquals("E 19.11515", this.format.getYInDecimalDegrees());
    }

    @Test
    public void getXInDegreesAndDecimalMinutes() {
        assertEquals("N 48° 45.297", this.format.getXInDegreesAndDecimalMinutes());
    }

    @Test
    public void getYInDegreesAndDecimalMinutes() {
        assertEquals("E 19° 6.909", this.format.getYInDegreesAndDecimalMinutes());
    }

    @Test
    public void getXInDegreesMinutesAndSeconds() {
    }

    @Test
    public void getYInDegreesMinutesAndSeconds() {
    }
}