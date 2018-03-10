package bisaggio.nasa.validator;

import bisaggio.nasa.service.util.MovementUtil;
import bisaggio.nasa.validator.exception.InvalidPositionException;
import bisaggio.nasa.domain.CardinalLocation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisaggio
 */
public class LocationValidatorTest {

    private CardinalLocation localization;
    private MovementUtil sut;

    @Before
    public void setUp() {
        localization = new CardinalLocation();
        sut = new MovementUtil();
        sut.setTerrainBoundaryX(5);
        sut.setTerrainBoundaryY(5);
    }

    @Test
    public void shouldReturnValidPosition() {
        sut.isPositionValid(localization);
        localization.setX(5);
        localization.setY(5);
        sut.isPositionValid(localization);
        assertTrue(true);
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldReturnInvalidPositionForXPositive() {
        localization.setX(6);
        sut.isPositionValid(localization);
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldReturnInvalidPositionForXNegative() {
        localization.setX(-1);
        sut.isPositionValid(localization);
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldReturnInvalidPositionForYPositive() {
        localization.setY(6);
        sut.isPositionValid(localization);
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldReturnInvalidPositionForYNegative() {
        localization.setY(-1);
        sut.isPositionValid(localization);
    }
}
