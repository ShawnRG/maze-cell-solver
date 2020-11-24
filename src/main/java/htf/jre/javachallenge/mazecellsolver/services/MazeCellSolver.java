package htf.jre.javachallenge.mazecellsolver.services;

import htf.jre.javachallenge.mazecellsolver.common.Maze;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class MazeCellSolver {
    private final WebClient client;

    public MazeCellSolver(WebClient client) {
        this.client = client;
    }

    public void run() {
        final Maze maze = client.get().retrieve().bodyToMono(Maze.class).block();

        assert maze != null;
        log.info(maze.toString());
    }
}
