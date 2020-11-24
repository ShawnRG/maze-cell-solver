package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

@Component("The following string is encrypted with an ancient algorithm, invented in one of the mightiest empires of all time.Tip: one of the leaders of this empire.")
public class CeasarChallenge implements Challenge {
    @Override
    public Object solve(String params) {
        return decrypt(params, 3);
    }
    public static StringBuffer decrypt(String cipher, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

}
