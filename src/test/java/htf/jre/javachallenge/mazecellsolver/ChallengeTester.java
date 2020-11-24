package htf.jre.javachallenge.mazecellsolver;

import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.SolvedCell;
import htf.jre.javachallenge.mazecellsolver.services.ChallengeSolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

    @Test
    void testBase64Conversion(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Decode the following String. It uses a quite common encoding, find out which!",
                "YldmOWZMODhuMnRtUkxhalM1VjZiblFqVk1qZmRUdzd5UVF1dW9zTm5mUlU=",
                0
        );
        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        //Should be bWf9fL88n2tmRLajS5V6bnQjVMjfdTw7yQQuuosNnfRU
        assertEquals("bWf9fL88n2tmRLajS5V6bnQjVMjfdTw7yQQuuosNnfRU",solvedCell.getAnswer());
    }

    @Test
    void testPrimeFinder(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Find all the primes between the start and end index (both inclusive)",
                "{\"start\":6021,\"end\":6121}",
                0
        );
        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        System.out.println(solvedCell);

    }

    @Test
    void testHexadecimalConversion(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Convert the following String to hexadecimal value (Use a space delimiter between values)",
                "UBHye7Csy5gp2EWVxrC",
                0
        );

        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        assertEquals("55 42 48 79 65 37 43 73 79 35 67 70 32 45 57 56 78 72 43",solvedCell.getAnswer());
    }

    @Test
    void testAlphabaticOrder(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Is the following string in alphabetical order? (Use N or Y as answer)",
                "aaaaaaaaabbccccdddeeeeggg",
                0
        );

        Cell cell2 = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Is the following string in alphabetical order? (Use N or Y as answer)",
                "bbbbaaa",
                0
        );

        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);
        SolvedCell solvedCell2 = challengeSolver.SolveCellChallenge(cell2);

        assertEquals("Y",solvedCell.getAnswer());
        assertEquals("N",solvedCell2.getAnswer());
    }

    @Test
    void testRegexGenerationOfString(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Provide a string that matches the regex",
                "[0-3]([a-c]|[e-g]{1,2}",
                0
        );

        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        System.out.println(solvedCell);
    }


    @Test
    void testHashmapRetriever(){
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Return element at index of the given hashmap",
                "{\"index\":\"3\",\"hashmap\":\"{1=BRc, 2=VmX, 3=h7F1, 4=NEE, 5=UYw}\"}",
                0
        );

        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        System.out.println(solvedCell.getAnswer());
    }

    @Test
    void TestMorseConversion() {
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Decode the following string",
                "-.-. ..- --.. .. . . -.. - .... .-..",
                0
        );

        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        System.out.println(solvedCell.getAnswer());
    }

    @Test
    void TestDayFinder() {
        Cell cell = new Cell(
                0,
                0,
                List.of("A", "B"),
                true,
                "yada",
                "Answer is the first and last day of the month (MONDAY - SUNDAY) eg: MONDAY-FRIDAY",
                "{\"month\":\"12\",\"year\":\"2019\"}",
                0
        );

        SolvedCell solvedCell = challengeSolver.SolveCellChallenge(cell);

        System.out.println(solvedCell.getAnswer());
    }
}
