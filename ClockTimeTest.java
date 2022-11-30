

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ClockTimeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockTimeTest
{
    /**
     * Default constructor for test class ClockTimeTest
     */
    public ClockTimeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testClockInitialization()
    {
        ClockTime clockTime = new ClockTime();
        clockTime.setHour(10);
        assertEquals(10, clockTime.getHour());
        clockTime.setMinute(10);
        assertEquals(10, clockTime.getMinute());
        clockTime.setSecond(61);
        assertEquals(1, clockTime.getSecond());
        assertEquals(11, clockTime.getMinute());
    }

    @Test
    public void testTwoClocks()
    {
        ClockTime clockTim1 = new ClockTime(8, 8, 8);
        ClockTime clockTim2 = new ClockTime(20, 21, 59);
        clockTim1.advance(3666);
        assertEquals("09:09:14", clockTim1.toString());
        assertEquals("08:21:59 P.M.", clockTim2.toString12());
        assertEquals(false, clockTim1.equals(clockTim2));
        clockTim1.setHour(20); clockTim1.setMinute(21); clockTim1.setSecond(59);
        assertEquals(true, clockTim1.equals(clockTim2));
    }
}


