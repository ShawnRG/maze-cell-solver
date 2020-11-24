package htf.jre.javachallenge.mazecellsolver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MazeResponse {
    private List<SolvedCell> cells;
}
