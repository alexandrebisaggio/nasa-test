/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.service;

import bisaggio.nasa.business.MovementBusiness;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisaggio
 */
public class MovimentTest {

    @Test
    public void testGetMoviments() {
        String steps = "MMRRLLMM";
        MovementBusiness moviment = new MovementBusiness();
        List<String> expResult = Arrays.asList("M","M","R","R","L","L","M","M"); 
        List<String> movimentList = moviment.getMoviments(steps);
        movimentList.removeAll(expResult);
        
        assertEquals(0, movimentList.size());
    }
    
}
