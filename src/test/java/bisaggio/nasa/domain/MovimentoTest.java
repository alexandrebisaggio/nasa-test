/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.domain;

import bisaggio.nasa.business.GoRigth;
import bisaggio.nasa.business.Move;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisaggio
 */
public class MovimentoTest {

    @Test
    public void testValues() {
        Movement[] expResult = {Movement.RIGHT, Movement.LEFT, Movement.FORWARD};
        Movement[] result = Movement.values();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetRegra() {
        System.out.println("getRegra");
        Movement instance = Movement.RIGHT;
        Move expResult = new GoRigth();
        Move result = instance.getRole();
        assertEquals(expResult.getClass(), result.getClass());
    }

}