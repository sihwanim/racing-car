package racing_car.utils;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class StringUtil {
    public static String limitLength(String s, int limitLen) {
        return s.length() <= limitLen ? s : s.substring(0, limitLen);
    }

    public static String[] removeDuplicates(String[] sArray) {
        LinkedHashSet<String> dedupe = new LinkedHashSet<>(Arrays.asList(sArray));
        return dedupe.toArray(new String[] {});
    }
}
