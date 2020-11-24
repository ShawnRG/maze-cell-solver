package htf.jre.javachallenge.mazecellsolver.maze;

import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.Direction;
import htf.jre.javachallenge.mazecellsolver.common.Maze;
import htf.jre.javachallenge.mazecellsolver.spatial.Vector;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class MazeTraverser {
    private Vector currentVector;
    private final Map<Vector, Cell> cellMap;
    private Maze maze;
    private final Set<Cell> visitedCells = new HashSet<>();

    public MazeTraverser(Maze maze) {
        cellMap = maze.getCells().stream().collect(Collectors.toMap(Cell::getVector, cell -> cell));
        this.maze = maze;
        log.info("Traversing maze -> {}", maze.getMazeId());
        log.info("Creating maze traverser with cell map \n, {}", cellMap);
    }


    public List<Cell> traverse() {
        log.trace("Traversing...");
        currentVector = Vector.zero();

        final Cell cell = cellMap.get(currentVector);
        List<Cell> path = new ArrayList<>();
        if (traverseCell(new Vector(-1,-1), cell, path)) {
            log.trace("found path -> {}", path);
            return path;
        } else {
            log.warn("no path found");
            return Collections.emptyList();
        }


    }

    public boolean traverseCell(Vector previousVector, Cell cell, List<Cell> path) {
        if (visitedCells.contains(cell)) {
            return false;
        }
        currentVector = cell.getVector();
        visitedCells.add(cell);
        path.add(cell);
        log.trace("Traversing cell, id: {} - ({}) -- With previous cell - ({})", cell.getChallengeId(), cell.getVector(), previousVector);
        if (maze.isExit(cell)) {
            return true;
        }
        final Vector position = cell.getVector();
        // do stuff
        final List<Cell> newCells = determineNewVectorsBasedOnDirections(cell).stream().peek(directions -> log.trace("new directions {}", directions)).filter(vector -> !previousVector.equals(vector)).map(cellMap::get).filter(Objects::nonNull).collect(Collectors.toList());
        for (Cell newCell : newCells) {
            if (traverseCell(cell.getVector(), newCell, path)) {
                return true;
            }
        }

        path.remove(path.size() -1);
        return false;

    }



    public Set<Vector> determineNewVectorsBasedOnDirections(Cell cell) {
        return cell.getNonBlockedDirections().stream().map(Direction::getVector).map(currentVector::moveDirection).collect(Collectors.toSet());
    }
}
