package CarRacing.Domain;

public class Position {
    private static final int POSITION_MIN = 0;
    private static String POSITION_ERROR_MESSAGE = "잘못된 위치입니다.";
    private int position = 0;

    public Position(int position){
        Position.validate(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    private static void validate(int position) {
        if(position < 0){
            throw new IllegalArgumentException(String.format(POSITION_ERROR_MESSAGE));
        }
    }



}
