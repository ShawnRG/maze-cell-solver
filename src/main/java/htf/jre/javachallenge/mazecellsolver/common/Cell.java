package htf.jre.javachallenge.mazecellsolver.common;

import htf.jre.javachallenge.mazecellsolver.spatial.Vector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cell {
    private int x;
    private int y;
    private List<String> sides;

    private boolean descisionPoint;
    private String challengeId;
    private String challenge;
    private String challengeParameters;

    private int prize;

    public Set<Direction> getNonBlockedDirections() {
        final List<Direction> directionList = sides.stream().map(Direction::valueOf).collect(Collectors.toList());
        return Direction.list.stream().filter(list -> !directionList.contains(list)).collect(Collectors.toSet());
    }

    public Vector getVector() {
        return new Vector(x, y);
    }
}
