package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

@Component("Convert the following String to hexadecimal value (Use a space delimiter between values)")
public class ConvertToHexadecimal implements Challenge{

    @Override
    public String solve(String params) {
        StringBuffer sb = new StringBuffer();
        //Converting string to character array
        char ch[] = params.toCharArray();
        for (char c : ch) {
            String hexString = Integer.toHexString(c);
            sb.append(hexString);
        }
        return sb.toString();
    }
}
