package bisaggio.nasa.domain;

/**
 *
 * @author bisaggio
 */
public enum Direction {

    N(360), E(90), S(180), W(270);

    public int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
