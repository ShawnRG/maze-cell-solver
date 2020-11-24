package htf.jre.javachallenge.mazecellsolver;

import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.SolvedCell;
import htf.jre.javachallenge.mazecellsolver.services.ChallengeSolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ChallengeTester {

    @Autowired
    private ChallengeSolver challengeSolver;

    @Test
    void testStringReplacer() {
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Replace string at given index in arraylist",
                "{\"index\":\"4\",\"arrayList\":\"[pYr, g78Y, HFL, Ele, 2oPW, fQQ, XVNe, Ny9U, fix, PLjj]\",\"replacement\":\"T4C5\"}",
                0
        );
        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        System.out.println(solvedCell);

    }
}
