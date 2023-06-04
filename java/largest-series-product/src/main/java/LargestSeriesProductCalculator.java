import java.util.Arrays;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) throws IllegalArgumentException {
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        } else if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else if (numberOfDigits == 0) {
            return 1;
        }

        return IntStream.rangeClosed(0, inputNumber.length() - numberOfDigits)
                .mapToObj(i -> Arrays.stream(inputNumber.substring(i, i + numberOfDigits).split(""))
                        .map(Long::parseLong)
                        .reduce((l, l2) -> l * l2).get())
                .max(Long::compareTo).get();
    }
}
