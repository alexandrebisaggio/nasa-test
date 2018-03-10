package bisaggio.nasa.business;

/**
 *
 * @author bisaggio
 */
public class GoLeft implements Move {

    @Override
    public void go(Location localization) {
        int x = 270;
        localization.turnAround(x);
    }

}
