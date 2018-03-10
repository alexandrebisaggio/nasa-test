package bisaggio.nasa.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import bisaggio.nasa.business.Location;

/**
 *
 * @author bisaggio
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CardinalLocation implements Location {

    private Integer x;
    private Integer y;
    private Direction direction;

    public CardinalLocation() {
        this.y = 0;
        this.x = 0;
        direction = Direction.N;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public void setX(Number x) {
        this.x = x.intValue();
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public void setY(Number y) {
        this.y = y.intValue();
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void turnAround(int round) {
        round = Math.round(((this.getDirection().getValue() + round) % 360) / 90);
        Direction directions[] = {Direction.N, Direction.E, Direction.S,
            Direction.W, Direction.N};
        this.setDirection(directions[round]);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + direction + ')';
    }

}
