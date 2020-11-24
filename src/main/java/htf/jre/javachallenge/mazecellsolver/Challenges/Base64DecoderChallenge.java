package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;

@Component("Decode the following String. It uses a quite common encoding, find out which!")
public class Base64DecoderChallenge implements Challenge{

    @Override
    public String solve(String params) {
        byte[] decodedBytes = Base64.getDecoder().decode(params);
        return new String(decodedBytes);
    }
}
