package htf.jre.javachallenge.mazecellsolver.services;

import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.MazeResponse;
import htf.jre.javachallenge.mazecellsolver.common.SolvedCell;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChallengeSolver {
    private final Map<String,Challenge> challengeMap;

    public ChallengeSolver(Map<String, Challenge> challengeMap) {
        this.challengeMap = challengeMap;
    }


    public SolvedCell SolveCellChallenge(Cell cell) {
        final Optional<Challenge> challengeOptional = Optional.ofNullable(challengeMap.get(cell.getChallenge()));
        final var solution = challengeOptional.map(challenge -> challenge.solve(cell.getChallengeParameters()));//.orElseThrow(() -> new NoChallengeFoundException(cell.getChallenge()))
        return new SolvedCell(
                cell.getX(),
                cell.getY(),
                cell.getChallengeId(),
                solution.get()
        );
    }

    public MazeResponse solveCells(Collection<Cell> cells) {
         return new MazeResponse(cells.stream().map(this::SolveCellChallenge).collect(Collectors.toList()));
    }


}
