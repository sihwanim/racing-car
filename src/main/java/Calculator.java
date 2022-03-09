public class Calculator {

    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        if (j == 0) {
            throw new IllegalArgumentException("분모는 0이어선 안된다.");
        }
        return i / j;
    }
}
