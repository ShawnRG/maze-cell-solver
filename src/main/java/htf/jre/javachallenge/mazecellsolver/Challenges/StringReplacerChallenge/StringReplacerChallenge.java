package htf.jre.javachallenge.mazecellsolver.Challenges.StringReplacerChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component("Replace string at given index in arraylist")
public class StringReplacerChallenge implements Challenge {

    @SneakyThrows
    @Override
    public String solve(String params) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringReplaceParams param =  objectMapper.readValue(params, StringReplaceParams.class);

        List<String> arrayList = Arrays.asList(param.arrayList.replace("[","").replace("]","") .split(", "));
        arrayList.set(param.index,param.replacement);

        return arrayList.toString();
    }
}
