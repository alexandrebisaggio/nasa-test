package bisaggio.nasa.domain;

import bisaggio.nasa.business.GoLeft;
import bisaggio.nasa.business.GoRigth;
import bisaggio.nasa.business.GoFoward;
import bisaggio.nasa.business.Move;

/**
 *
 * @author bisaggio
 */
public enum Movement {
    RIGHT(new GoRigth()),
    LEFT(new GoLeft()),
    FORWARD(new GoFoward());

    private final Move role;

    Movement(Move role) {
        this.role = role;
    }

    public Move getRole() {
        return role;
    }

}
