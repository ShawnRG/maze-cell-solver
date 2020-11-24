package htf.jre.javachallenge.mazecellsolver.spatial;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Vector {
    private int x;
    private int y;

    public Vector(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public static Vector zero() {
        return new Vector(0,0);
    }

    public Vector moveDirection(Vector vector) {
        final Vector newVector = new Vector(this);
        newVector.x += vector.x;
        newVector.y += vector.y;

        return newVector;
    }
}
