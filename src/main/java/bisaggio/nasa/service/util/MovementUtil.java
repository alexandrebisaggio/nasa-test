package bisaggio.nasa.service.util;

import bisaggio.nasa.validator.exception.InvalidPositionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import bisaggio.nasa.business.Location;

/**
 *
 * @author bisaggio
 */
@Component
public class MovementUtil {

    @Value("${mars.terrain.boundary.x}")
    private Integer terrainBoundaryX;

    @Value("${mars.terrain.boundary.y}")
    private Integer terrainBoundaryY;

    public void isPositionValid(Location localization) {
        if (localization.getX().intValue() < 0 || localization.getY().intValue() < 0
                || localization.getX().intValue() > terrainBoundaryY 
                || localization.getY().intValue() > terrainBoundaryX) {
            throw new InvalidPositionException();
        }
    }

    public void setTerrainBoundaryX(Integer terrainBoundaryX) {
        this.terrainBoundaryX = terrainBoundaryX;
    }

    public void setTerrainBoundaryY(Integer terrainBoundaryY) {
        this.terrainBoundaryY = terrainBoundaryY;
    }

}
