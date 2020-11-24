package htf.jre.javachallenge.mazecellsolver.common;

import htf.jre.javachallenge.mazecellsolver.spatial.Vector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Maze {
    private String mazeId;
    private List<Cell> cells;
    private Integer maxX;
    private Integer maxY;


    public boolean isExit(Cell cell) {
        if (maxX == null || maxY == null) {
             maxX = cells.stream().mapToInt(Cell::getX).max().getAsInt();
                maxY = cells.stream().mapToInt(Cell::getY).max().getAsInt();
        }
        return (cell.getVector().equals(new Vector(maxX, maxY
        )));
    }
}
