package htf.jre.javachallenge.mazecellsolver.services;

import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import htf.jre.javachallenge.mazecellsolver.common.Cell;
import htf.jre.javachallenge.mazecellsolver.common.SolvedCell;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ChallengeSolver {
    private final Map<String,Challenge> challengeMap;

    public ChallengeSolver(Map<String, Challenge> challengeMap) {
        this.challengeMap = challengeMap;
    }


    public SolvedCell SolveCellChallenge(Cell cell){
        return new SolvedCell(
                cell.getX(),
                cell.getY(),
                cell.getChallengeId(),
                challengeMap.get(cell.getChallenge()).solve(cell.getChallengeParameters())
        );
    }


}
