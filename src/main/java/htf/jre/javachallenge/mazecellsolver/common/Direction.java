package htf.jre.javachallenge.mazecellsolver.common;


import htf.jre.javachallenge.mazecellsolver.spatial.Vector;
import org.springframework.util.StreamUtils;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH(new Vector(0, -1)), EAST(new Vector(1, 0)), SOUTH(new Vector(0, 1)), WEST(new Vector(-1, 0));

    private final Vector vector;


    Direction(Vector vector) {
        this.vector = vector;
    }

    public Vector getVector() {
        return vector;
    }

    public static List<Direction> list = Arrays.asList(values());
}
