package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("Reverse the following String")
public class StringReverser implements Challenge {
    @Override
    public String solve(String params) {
        return new StringBuilder(params).reverse().toString();
    }
}
