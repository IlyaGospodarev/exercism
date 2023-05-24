import java.util.stream.IntStream;

class CollatzCalculator {
    int computeStepCount(int start) throws IllegalArgumentException {
        if (start <= 0) {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }

        return (int) IntStream.iterate(start, i -> i > 1, i -> i % 2 == 0 ? i / 2 : i * 3 + 1).count();
    }
}
