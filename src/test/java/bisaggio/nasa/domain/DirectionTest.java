/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisaggio
 */
public class DirectionTest {

    Direction sut;

    @Before
    public void setUp() {
        sut = Direction.N;
    }

    @Test
    public void testValues() {
        Direction[] expResult = {Direction.N, Direction.E, Direction.S, Direction.W};
        Direction[] result = Direction.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getValor method, of class Direction.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        int expResult = 360;
        int result = sut.getValue();
        assertEquals(expResult, result);
    }

}
