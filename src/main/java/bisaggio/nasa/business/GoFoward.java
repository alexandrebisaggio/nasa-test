package bisaggio.nasa.business;

import bisaggio.nasa.service.exception.InvalidStepException;

/**
 *
 * @author bisaggio
 */
public class GoFoward implements Move{

    @Override
    public void go(Location localization) {

        switch (localization.getDirection()) {
            case N:
                localization.setY(localization.getY().intValue() + 1);
                break;
            case W:
                localization.setX(localization.getX().intValue() - 1);
                break;
            case E:
                localization.setX(localization.getX().intValue() + 1);
                break;
            case S:
                localization.setY(localization.getY().intValue() - 1);
                break;
            default:
                throw new InvalidStepException();
        }
    }



}
