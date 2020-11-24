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

import static htf.jre.javachallenge.mazecellsolver.common.MazeResponseFactory.createResponse;

@Service
@Slf4j
public class MazeCellSolver {
    private final WebClient client;
    private final ChallengeSolver challengeSolver;

    public MazeCellSolver(WebClient client, ChallengeSolver challengeSolver) {
        this.client = client;
        this.challengeSolver = challengeSolver;
    }

    public void run() {
        final Maze maze = client.get().uri("/", uriBuilder -> uriBuilder.queryParam("teamId", Constants.TEAM_ID).build()).retrieve().bodyToMono(Maze.class).block();

        assert maze != null;
        final List<Cell> cellList = new MazeTraverser(maze).traverse();

        if (cellList.stream().noneMatch(Cell::hasChallenge)) {
            log.warn("No Challenges");
            final MazeResponse mazeResponse = createResponse(cellList);
            final String response = submitAnswer(maze, mazeResponse);
            log.info(response);
        } else {
            log.info("Has challenges");
            try {
                final MazeResponse mazeResponse = challengeSolver.solveCells(cellList);
                final String response = submitAnswer(maze, mazeResponse);
                log.info(response);
            } catch (NoChallengeFoundException e) {
                log.error("Could not found challenge solver with name {}", e.getMessage());
            }

        }
    }


    private String submitAnswer(Maze maze, MazeResponse mazeResponse) {
        final var response = client.post().uri("/" + maze.getMazeId()).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(mazeResponse))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is5xxServerError()) {
                        clientResponse.body((clientHttpResponse, context) -> {
                            return clientHttpResponse.getBody();
                        });
                        return clientResponse.bodyToMono(String.class);
                    }
                    else
                        return clientResponse.bodyToMono(String.class);
                }).block();
        return response;
    }

}
