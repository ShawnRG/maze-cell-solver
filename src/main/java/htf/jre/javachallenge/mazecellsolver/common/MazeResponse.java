package htf.jre.javachallenge.mazecellsolver.common;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MazeResponse {
    private final List<SolvedCell> cells;
}
