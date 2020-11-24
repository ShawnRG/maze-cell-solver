package htf.jre.javachallenge.mazecellsolver.Challenges.PrimeFinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component("Find all the primes between the start and end index (both inclusive)")
public class PrimeFinder implements Challenge {

    @SneakyThrows
    @Override
    public String solve(String params) {
        ObjectMapper objectMapper = new ObjectMapper();
        PrimeFinderParams param =  objectMapper.readValue(params, PrimeFinderParams.class);
        return findPrimesInRange(param.start, param.end);
    }

    private String findPrimesInRange(int start, int end) {
        List<String> primeList = new LinkedList<>();
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
                primeList.add(String.valueOf(i));
        }
        return String.valueOf(primeList);
    }
}
