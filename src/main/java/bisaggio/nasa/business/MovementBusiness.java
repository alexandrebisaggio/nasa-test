
package bisaggio.nasa.business;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author bisaggio
 */
@Component
public class MovementBusiness {

    public List<String> getMoviments(String steps) {
        List<String> actions = new ArrayList<>();
        
        steps.chars().mapToObj(step -> (char) step)
                .forEach(command -> {
                    actions.add(command.toString());
                });

        return actions;
    }
}
