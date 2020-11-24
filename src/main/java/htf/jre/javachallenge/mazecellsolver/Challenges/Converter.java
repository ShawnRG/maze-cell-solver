package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;

@Component("Decode the following String. It uses a quite common encoding, find out which!")
public class Converter implements Challenge{

    @Override
    public String solve(String params) {
        return Arrays.toString(Base64.getDecoder().decode(params));
    }
}
