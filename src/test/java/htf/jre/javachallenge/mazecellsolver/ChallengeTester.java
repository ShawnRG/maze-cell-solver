package htf.jre.javachallenge.mazecellsolver;

import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.SolvedCell;
import htf.jre.javachallenge.mazecellsolver.services.ChallengeSolver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

@SpringBootTest
@Slf4j
public class ChallengeTester {

    @Autowired
    private ChallengeSolver challengeSolver;

    @Test
    public void testStringReplacer(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A","B"),
                true,
                "yada",
                "ya",
                "{\"index\":\"4\",\"arrayList\":\"[pYr, g78Y, HFL, Ele, 2oPW, fQQ, XVNe, Ny9U, fix, PLjj]\",\"replacement\":\"T4C5\"}",
                0
        );
        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        log.info(solvedCell.toString());
    }

}
