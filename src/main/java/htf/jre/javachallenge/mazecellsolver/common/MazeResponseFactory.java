package htf.jre.javachallenge.mazecellsolver.common;

import java.util.List;
import java.util.stream.Collectors;

public class MazeResponseFactory {
    public static MazeResponse createResponse(List<Cell> cells) {
        return new MazeResponse(cells.stream().map(SolvedCellFactory::createFromCell).collect(Collectors.toList()));
    }
}
