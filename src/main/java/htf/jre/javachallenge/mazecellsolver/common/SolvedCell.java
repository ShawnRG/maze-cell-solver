package htf.jre.javachallenge.mazecellsolver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolvedCell {
    private int x;
    private int y;
    private String challengeId;
    private String answer;
}
