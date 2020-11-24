package htf.jre.javachallenge.mazecellsolver.services;

import htf.jre.javachallenge.mazecellsolver.common.*;
import htf.jre.javachallenge.mazecellsolver.maze.MazeTraverser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MazeCellSolver {
    private final WebClient client;

    public MazeCellSolver(WebClient client) {
        this.client = client;
    }

    public void run() {
        final Maze maze = client.get().uri("/", uriBuilder -> uriBuilder.queryParam("teamId", Constants.TEAM_ID).build()).retrieve().bodyToMono(Maze.class).block();

        assert maze != null;
        //log.info(maze.toString());
        final List<Cell> cellList = new MazeTraverser(maze).traverse();

        if (cellList.stream().noneMatch(Cell::isDescisionPoint)) {
            log.warn("FOUND ONE");
            final var response = client.post().uri("/" + maze.getMazeId()).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(createResponse(cellList))).retrieve()
                    .bodyToMono(String.class).block();
            log.error(response);
        }
    }

    private static MazeResponse createResponse(List<Cell> cells) {
        return new MazeResponse(cells.stream().map(SolvedCellFactory::createFromCell).collect(Collectors.toList()));
    }
}
