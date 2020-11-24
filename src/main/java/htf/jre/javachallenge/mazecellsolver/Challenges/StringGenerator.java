package htf.jre.javachallenge.mazecellsolver.Challenges;

import com.github.curiousoddman.rgxgen.RgxGen;
import org.springframework.stereotype.Component;

@Component("Provide a string that matches the regex")
public class StringGenerator implements Challenge {
    @Override
    public String solve(String params) {
        RgxGen rgxGen = new RgxGen(params);         // Create generator
        return rgxGen.generate();
    }
}
