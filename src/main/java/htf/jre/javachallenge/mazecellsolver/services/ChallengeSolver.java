package htf.jre.javachallenge.mazecellsolver.services;

import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.MazeResponse;
import htf.jre.javachallenge.mazecellsolver.common.SolvedCell;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ChallengeSolver {
    private final Map<String,Challenge> challengeMap;

    public ChallengeSolver(Map<String, Challenge> challengeMap) {
        this.challengeMap = challengeMap;
    }


    public SolvedCell SolveCellChallenge(Cell cell) throws NoChallengeFoundException {

        final Optional<Challenge> challengeOptional = Optional.ofNullable(challengeMap.get(cell.getChallenge()));
        final var solution = challengeOptional.map(challenge -> challenge.solve(cell.getChallengeParameters()));
        final var answer = solution.orElse(null);
        if (answer != null) {
            log.info("Challenge ({}) with answer: {}", challengeOptional.get(), answer);
        }

        return new SolvedCell(
                cell.getX(),
                cell.getY(),
                cell.getChallengeId(),
                answer
        );
    }

    public MazeResponse solveCells(Collection<Cell> cells) throws NoChallengeFoundException {
         return new MazeResponse(cells.stream().map(this::SolveCellChallenge).collect(Collectors.toList()));
    }


}
