package htf.jre.javachallenge.mazecellsolver.common;

public final class SolvedCellFactory {
    public static SolvedCell createFromCell(Cell cell) {
        return new SolvedCell(
                cell.getX(),
                cell.getY(),
                cell.getChallengeId(),
                null
        );
    }
}
