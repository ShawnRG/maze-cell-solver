package htf.jre.javachallenge.mazecellsolver.Challenges.disarium;

import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import org.springframework.stereotype.Component;

@Component("Is the following number a Disarium Number? (Use N or Y as answer)")
public class DisariumChallenge implements Challenge {

    @Override
    public String solve(String params) {

        int num = Integer.parseInt(params);
        int copy = num, d = 0, sum = 0;
        String s = Integer.toString(num);
        int len = s.length();

        while(copy>0)
        {
            d = copy % 10;
            sum = sum + (int)Math.pow(d,len);
            len--;
            copy = copy / 10;
        }

        return sum == num ? "Y" : "N";
    }
}
