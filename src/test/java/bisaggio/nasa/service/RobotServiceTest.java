/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.service;

import bisaggio.nasa.business.Location;
import bisaggio.nasa.business.MovementBusiness;
import bisaggio.nasa.domain.CardinalLocation;
import bisaggio.nasa.service.exception.InvalidStepException;
import bisaggio.nasa.domain.Robot;
import bisaggio.nasa.service.util.MovementUtil;
import bisaggio.nasa.validator.exception.InvalidPositionException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author bisaggio
 */
//@RunWith(SpringRunner.class)
public class RobotServiceTest {

    private Robot robot;

    private final MovementBusiness moviment = new MovementBusiness();
    private final MovementUtil locationValidator = new MovementUtil();

    private Location localizationCardinal;

    private RobotService sut;

    @Before
    public void setup() {
        localizationCardinal = new CardinalLocation();
        robot = new Robot(localizationCardinal);
        locationValidator.setTerrainBoundaryX(5);
        locationValidator.setTerrainBoundaryY(5);
        sut = new RobotService(moviment, locationValidator);
    }

    @Test
    public void MustGoSouth2SouthFacing() throws Exception {
        robot = sut.moveTo("MMRMMRMM", robot);
        assertEquals("(2, 0, S)", robot.getLocation().toString());
    }

    @Test
    public void MustGoWest2WestFacing() throws Exception {
        robot = sut.moveTo("MML", robot);
        assertEquals("(0, 2, W)", robot.getLocation().toString());
    }

    @Test
    public void shouldReturnTerrainBoundaryFacingEast() throws Exception {
        robot = sut.moveTo("MMMMMRMMMMM", robot);
        assertEquals("(5, 5, E)", robot.getLocation().toString());
    }

    @Test(expected = InvalidStepException.class)
    public void shouldReturnInvalidMovement() throws Exception {
        robot = sut.moveTo("AAA", robot);
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldReturnMovementOffTheGround() throws Exception {
        robot = sut.moveTo("MMMMMMMMMMM", robot);
    }

}
