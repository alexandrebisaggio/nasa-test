
package bisaggio.nasa.service;

import bisaggio.nasa.service.exception.InvalidStepException;
import bisaggio.nasa.domain.Movement;

/**
 *
 * @author bisaggio
 */
public class MovimentoFactory {    
    
    public static Movement buildMovimento(String movimento) {
        switch (movimento) {
            case "M":
                return Movement.FORWARD;
            case "L":
                return Movement.LEFT;
            case "R":
                return Movement.RIGHT;
            default:
                throw new InvalidStepException();
        }
    }

}
