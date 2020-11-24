package htf.jre.javachallenge.mazecellsolver.Challenges.HashmapRetriever;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("Return element at index of the given hashmap")
public class HashmapRetriever implements Challenge {
    @SneakyThrows
    @Override
    public String solve(String params) {
        ObjectMapper objectMapper = new ObjectMapper();
        HashmapParams param =  objectMapper.readValue(params, HashmapParams.class);
        HashMap<String,String> hashMap = new HashMap<>();
        param.hashmap = param.hashmap.replace("{", "").replace("}","");
        for (String s : param.hashmap.split(", ")) {
            hashMap.put(s.split("=")[0],s.split("=")[1]);
        }
        return hashMap.get(param.index);
    }
}
