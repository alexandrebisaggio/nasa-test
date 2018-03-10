package bisaggio.nasa.business;

/**
 *
 * @author bisaggio
 */
public class GoRigth implements Move {

    @Override
    public void go(Location localization) {
        int x = 90;                
        localization.turnAround(x);
    }



}
