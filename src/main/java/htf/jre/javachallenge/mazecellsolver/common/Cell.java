package htf.jre.javachallenge.mazecellsolver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
