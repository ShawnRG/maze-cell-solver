package htf.jre.javachallenge.mazecellsolver.common;


import htf.jre.javachallenge.mazecellsolver.spatial.Vector;

public enum Direction {
    NORTH(new Vector(0, -1)), EAST(new Vector(1, 0)), SOUTH(new Vector(0, 1)), WEST(new Vector(-1, 0));

    private final Vector vector;


    Direction(Vector vector) {
        this.vector = vector;
    }
}
