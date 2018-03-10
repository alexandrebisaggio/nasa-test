package bisaggio.nasa.domain;

import java.util.List;
import bisaggio.nasa.business.Location;

/**
 *
 * @author bisaggio
 */
public class Robot {

    private List<String> comandList;
    private Location location;

    public Robot(Location localization) {
        this.location = localization;
    }

    public List<String> getComandList() {
        return comandList;
    }

    public void setComandList(List<String> comandList) {
        this.comandList = comandList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void drive(Movement movimento) {
        movimento.getRole().go(this.location);
    }

}
