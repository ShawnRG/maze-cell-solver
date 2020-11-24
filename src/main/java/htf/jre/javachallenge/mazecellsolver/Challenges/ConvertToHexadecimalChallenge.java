package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component("Convert the following String to hexadecimal value (Use a space delimiter between values)")
public class ConvertToHexadecimalChallenge implements Challenge{

    @Override
    public String solve(String params) {
        StringBuffer sb = new StringBuffer();
        //Converting string to character array
        return params.chars().mapToObj(Integer::toHexString).collect(Collectors.joining(" "));
    }
}
