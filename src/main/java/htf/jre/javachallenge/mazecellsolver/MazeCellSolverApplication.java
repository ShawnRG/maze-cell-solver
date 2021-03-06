package htf.jre.javachallenge.mazecellsolver;

import htf.jre.javachallenge.mazecellsolver.services.MazeCellSolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MazeCellSolverApplication implements CommandLineRunner {

    private final MazeCellSolver cellSolver;

    public MazeCellSolverApplication(MazeCellSolver cellSolver) {
        this.cellSolver = cellSolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(MazeCellSolverApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		while(true) {
			cellSolver.run();
			Thread.sleep(750);
		}

    }
}
