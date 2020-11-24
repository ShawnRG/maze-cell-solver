package htf.jre.javachallenge.mazecellsolver.maze;

import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.Direction;
import htf.jre.javachallenge.mazecellsolver.common.Maze;
import htf.jre.javachallenge.mazecellsolver.spatial.Vector;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class MazeTraverser {
    private Vector currentVector;
    private final Map<Vector, Cell> cellMap;

    public MazeTraverser(Maze maze) {
        cellMap = maze.getCells().stream().collect(Collectors.toMap(Cell::getVector, cell -> cell));
        log.info("Traversing maze -> {}", maze.getMazeId());
        log.info("Creating maze traverser with cell map \n, {}", cellMap);
    }


    public void traverse() {
        log.info("Traversing...");
        currentVector = Vector.zero();

        final Cell cell = cellMap.get(currentVector);
        traverseCell(new Vector(-1,-1), cell);

    }

    public void traverseCell(Vector previousVector, Cell cell) {
        currentVector = cell.getVector();
        log.info("Traversing cell, id: {} - ({}) -- With previous cell - ({})", cell.getChallengeId(), cell.getVector(), previousVector);
        final Vector position = cell.getVector();
        // do stuff
        determineNewVectorsBasedOnDirections(cell).stream().peek(directions -> log.info("new directions {}", directions)).filter(vector -> !previousVector.equals(vector)).map(cellMap::get).filter(Objects::nonNull).forEach(newCell -> {
            traverseCell(cell.getVector(), newCell);
        });

    }

    public Set<Vector> determineNewVectorsBasedOnDirections(Cell cell) {
        return cell.getNonBlockedDirections().stream().map(Direction::getVector).map(currentVector::moveDirection).collect(Collectors.toSet());
    }
}
