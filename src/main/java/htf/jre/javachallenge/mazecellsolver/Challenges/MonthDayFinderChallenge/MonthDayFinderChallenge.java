package htf.jre.javachallenge.mazecellsolver.Challenges.MonthDayFinderChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import htf.jre.javachallenge.mazecellsolver.Challenges.Challenge;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;

@Slf4j
@Component("Answer is the first and last day of the month (MONDAY - SUNDAY) eg: MONDAY-FRIDAY")
public class MonthDayFinderChallenge implements Challenge {

    @SneakyThrows
    @Override
    public Object solve(String params) {
        ObjectMapper objectMapper = new ObjectMapper();
        MonthDayParams param =  objectMapper.readValue(params, MonthDayParams.class);
        YearMonth yearMonth = YearMonth.of( param.year, param.month );
        LocalDate firstOfMonth = yearMonth.atDay( 1 );
        LocalDate last = yearMonth.atEndOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(firstOfMonth.getDayOfWeek());
        sb.append("-");
        sb.append(last.getDayOfWeek());
        return sb.toString();
    }
}
