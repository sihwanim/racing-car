package CarRacing.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RacingGameFactory {
    private static final String NAME_SPLIT_DELIMETER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    private RacingGameFactory() {

    }

    public static Cars inputCars(String inputName) {
        String[] nameList = inputName.split(NAME_SPLIT_DELIMETER);
        return new Cars(Arrays.stream(nameList)
                .map(Car::new)
                .collect(Collectors.toList()));

    }

    public int inputPlayNum(String inputNum){
        Matcher matcher = NUMBER_PATTERN.matcher(inputNum);
        if(!matcher.matches())
            throw new IllegalArgumentException();
        return Integer.parseInt(inputNum);
    }
}
