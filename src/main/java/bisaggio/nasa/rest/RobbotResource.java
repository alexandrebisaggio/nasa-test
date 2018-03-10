package bisaggio.nasa.rest;

import bisaggio.nasa.domain.Robot;
import bisaggio.nasa.service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bisaggio.nasa.business.Location;

/**
 *
 * @author bisaggio
 */
@RestController
@RequestMapping("/rest")
public class RobbotResource {

    private final RobotService robotService;
    private final Location location; 

    public RobbotResource(RobotService robotService, Location location) {
        this.robotService = robotService;
        this.location = location;
    }
    

    @PostMapping(value = "/mars/{steps}")
    public ResponseEntity<?> goToSteps(@PathVariable String steps) {
        Robot robot = new Robot(location);
        robot = robotService.moveTo(steps, robot);
        return ResponseEntity.ok(robot.getLocation().toString());
    }
}
