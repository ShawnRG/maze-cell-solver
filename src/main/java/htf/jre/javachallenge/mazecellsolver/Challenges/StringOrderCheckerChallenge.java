package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("Is the following string in alphabetical order? (Use N or Y as answer)")
public class StringOrderCheckerChallenge implements Challenge {
    @Override
    public String solve(String params) {
        // length of the string
        int n = params.length();

        // create a character array
        // of the length of the string
        char c[] = new char [n];

        // assign the string
        // to character array
        for (int i = 0; i < n; i++) {
            c[i] = params.charAt(i);
        }

        // sort the character array
        Arrays.sort(c);

        // check if the character array
        // is equal to the string or not
        for (int i = 0; i < n; i++)
            if (c[i] != params.charAt(i))
                return "N";

        return "Y";
    }
}
