/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.service;

import bisaggio.nasa.business.GoLeft;
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
public class GoLeftTest {

    private GoLeft sut;

    @Before
    public void setUp() {
        sut = new GoLeft();
    }

    @Test
    public void houldRotateFromNortToToWest() {
        CardinalLocation localization = new CardinalLocation();
        localization.setDirection(Direction.N);
        sut.go(localization);
        assertEquals(localization.getDirection(), Direction.W);
    }

    @Test
    public void houldRotateFromWestToSouth() {
        CardinalLocation localization = new CardinalLocation();
        localization.setDirection(Direction.W);
        sut.go(localization);
        assertEquals(localization.getDirection(), Direction.S);
    }

    @Test
    public void houldRotateFromSouthToEast() {
        CardinalLocation localization = new CardinalLocation();
        localization.setDirection(Direction.S);
        sut.go(localization);
        assertEquals(localization.getDirection(), Direction.E);
    }

    @Test
    public void houldRotateFromEastToNorth() {
        CardinalLocation localization = new CardinalLocation();
        localization.setDirection(Direction.E);
        sut.go(localization);
        assertEquals(localization.getDirection(), Direction.N);
    }

}
