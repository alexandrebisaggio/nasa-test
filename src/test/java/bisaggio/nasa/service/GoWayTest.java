/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.service;

import bisaggio.nasa.business.GoFoward;
import bisaggio.nasa.domain.Direction;
import bisaggio.nasa.domain.CardinalLocation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisaggio
 */
public class GoWayTest {

    private GoFoward sut;
    private CardinalLocation localization;

    @Before
    public void setUp() {
        sut = new GoFoward();
        localization = new CardinalLocation();
    }

    @Test
    public void shouldGoOneStepNorth() {
        sut.go(localization);
        assertEquals("(0, 1, N)", localization.toString());
    }
    
    @Test
    public void shouldGoOneStepEast() {
        localization.setDirection(Direction.E);
        sut.go(localization);
        assertEquals("(1, 0, E)", localization.toString());
    }
    
    @Test
    public void shouldGoOneStepSouth() {
        localization.setDirection(Direction.S);
        localization.setY(3);
        localization.setX(3);
        sut.go(localization);
        assertEquals("(3, 2, S)", localization.toString());
    }
    
    @Test
    public void shouldGoOneStepWest() {
        localization.setDirection(Direction.W);
        localization.setY(3);
        localization.setX(3);
        sut.go(localization);
        assertEquals("(2, 3, W)", localization.toString());
    }

}
