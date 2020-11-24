package htf.jre.javachallenge.mazecellsolver.Challenges.StringReplacer;

import com.fasterxml.jackson.databind.ObjectMapper;
import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("Replace string at given index in arraylist")
public class StringReplacer implements Challenge {

    @SneakyThrows
    @Override
    public String solve(String params) {
        //"{\"index\":\"4\",\"arrayList\":\"[pYr, g78Y, HFL, Ele, 2oPW, fQQ, XVNe, Ny9U, fix, PLjj]\",\"replacement\":\"T4C5\"}"
        ObjectMapper objectMapper = new ObjectMapper();
        StringReplaceParams param =  objectMapper.readValue(params, StringReplaceParams.class);
        log.info(param.toString());
        return "Ok";
    }
}
