package htf.jre.javachallenge.mazecellsolver.Challenges;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component("Decode the following string")
public class MorseCodeMapperChallenge implements Challenge {
    Map<String, String> library = new HashMap<String, String>();

    public MorseCodeMapper() {
        init();
    }
    void init(){
        library.put(".-", "A");
        library.put("-...", "B");
        library.put("-.-.", "C");
        library.put("-..", "D");
        library.put(".", "E");
        library.put("..-.", "F");
        library.put("--.", "G");
        library.put("....", "H");
        library.put("..", "I");
        library.put(".---", "J");
        library.put("-.-", "K");
        library.put(".-..", "L");
        library.put("--", "M");
        library.put("-.", "N");
        library.put("---", "O");
        library.put(".--.", "P");
        library.put("--.-", "Q");
        library.put(".-.", "R");
        library.put("...", "S");
        library.put("-", "T");
        library.put("..-", "U");
        library.put("...-", "V");
        library.put(".--", "W");
        library.put("-..-", "X");
        library.put("-.--", "Y");
        library.put("--..", "Z");

        library.put(".----", "1");
        library.put("..---", "2");
        library.put("...--", "3");
        library.put("....-", "4");
        library.put(".....", "5");
        library.put("-....", "6");
        library.put("--...", "7");
        library.put("---..", "8");
        library.put("----.", "9");
        library.put("-----", "0");
    }


    @Override
    public String solve(String params) {
        return Arrays.stream(params.split(" ")).map(library::get).map(String::toLowerCase).collect(Collectors.joining());
    }
}
