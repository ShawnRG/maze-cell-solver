package htf.jre.javachallenge.mazecellsolver.Challenges.PrimeFinderChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("Find all the primes between the start and end index (both inclusive)")
public class PrimeFinderChallenge implements Challenge {

    @SneakyThrows
    @Override
    public Object solve(String params) {
        ObjectMapper objectMapper = new ObjectMapper();
        PrimeFinderParams param =  objectMapper.readValue(params, PrimeFinderParams.class);
        return findPrimesInRange(param.start, param.end);
    }

    private Object findPrimesInRange(int start, int end) {
        List<Integer> primeList = new ArrayList<>();
        int count;
        for(int i = start ; i <= end ; i++)
        {
            count = 0;
            for(int j = 1 ; j <= i ; j++)
            {
                if(i % j == 0)
                    count = count+1;
            }
            if(count == 2)
                primeList.add(i);
        }
        return primeList;
    }
}
