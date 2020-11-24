package htf.jre.javachallenge.mazecellsolver.Challenges;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import reactor.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("Find the missing numbers in the sequence. Return them as a comma-separated string")
public class FibonacciSequence implements Challenge {
    @Override
    public Object solve(String params) {
        try {
            final List<Integer> sequence = new ObjectMapper().readValue(params, List.class);
            List<String> sequences = new ArrayList<>();
            var highest = 0;

            for (int i = 0; i < sequence.size(); i++) {
                if (i+1 == sequence.size()) continue;
                final var curr = sequence.get(i);
                final var next = sequence.get(i + 1);

                if (curr <= next) {
                    sequence.addAll(fib(curr, next));
                }
            }
            return String.join(",", sequences);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Integer> fib(int start, int end) {
        List<Integer> foundNumbers = new ArrayList<>();
        int f1 = 0, f2 = 1, f3 = 1;
        while (f1 < end)
        {
            if (f1 > start)
                foundNumbers.add(f1);
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }

        return foundNumbers;
    }
}
