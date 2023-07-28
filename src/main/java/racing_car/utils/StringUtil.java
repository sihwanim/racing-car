package racing_car.utils;

public class StringUtil {
    public static String limitFiveOrLessLength(String s) {
        return s.length() <= 5 ? s : s.substring(0, 5);
    }
}
