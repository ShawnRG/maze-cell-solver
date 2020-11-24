package htf.jre.javachallenge.mazecellsolver.Challenges.StringReplacer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
class StringReplaceParams {
    int index;
    ArrayList<String> arrayList;
    String replacement;
}
