package bisaggio.nasa.service;

import bisaggio.nasa.business.MovementBusiness;
import bisaggio.nasa.domain.Robot;
import bisaggio.nasa.service.util.MovementUtil;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bisaggio
 */
@Service
public class RobotService {

    private final MovementBusiness moviment;

    private final MovementUtil locationValidator;

    public RobotService(MovementBusiness moviment, MovementUtil locationValidator) {
        this.moviment = moviment;
        this.locationValidator = locationValidator;
    }

    public Robot moveTo(String steps, Robot robot) {

        List<String> moviments = moviment.getMoviments(steps);
        moviments.forEach((step) -> {
            robot.drive(MovimentoFactory.buildMovimento(step));
        });

        locationValidator.isPositionValid(robot.getLocation());
        return robot;
    }

}
