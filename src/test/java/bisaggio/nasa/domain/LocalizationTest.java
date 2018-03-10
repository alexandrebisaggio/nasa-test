
package bisaggio.nasa.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import bisaggio.nasa.business.Location;

/**
 *
 * @author bisaggio
 */
public class LocalizationTest {

    private Location sut;

    @Before
    public void setUp() {
        sut = new CardinalLocation();
    }

    @Test
    public void shouldTurnFromNorthToEast() {

        Direction N = Direction.N;
        sut.turnAround(N.getValue() + 90);
        assertEquals(sut.getDirection(), Direction.E);

    }

    @Test
    public void shouldTurnFromNorthToWest() {
        Direction N = Direction.N;
        sut.turnAround(N.getValue() + 270);
        assertEquals(sut.getDirection(), Direction.W);
    }

    @Test
    public void testGetX() {
        int expResult = 0;
        int result = sut.getX().intValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetX() {
        int x = 5;
        sut.setX(x);
        assertEquals(x, sut.getX());
    }

    @Test
    public void testGetY() {
        int expResult = 0;
        int result = sut.getY().intValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 5;
        sut.setY(y);
        assertEquals(y, sut.getY());
    }

   
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Direction expResult = Direction.N;
        Direction result = sut.getDirection();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDirection() {
        Direction direction = Direction.W;
        sut.setDirection(direction);

        assertEquals(direction, sut.getDirection());
    }

    @Test
    public void testToString() {
        sut.setY(5);
        sut.setX(5);
        sut.setDirection(Direction.W);
        String expResult = "(5, 5, W)";
        String result = sut.toString();
        assertEquals(expResult, result);

    }
}
