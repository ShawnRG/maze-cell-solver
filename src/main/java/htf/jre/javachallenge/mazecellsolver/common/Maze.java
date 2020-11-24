package htf.jre.javachallenge.mazecellsolver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maze {
    private String mazeId;
    private List<Cell> cells;
}
