import java.util.Arrays;

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

        long max = 0;

        for (int i = 0; i <= inputNumber.length() - numberOfDigits; i++) {
            String[] number = inputNumber.substring(i, i + numberOfDigits).split("");
            var series = Arrays.stream(number).map(Long::parseLong).reduce((l, l2) -> l * l2).get();
            max = Math.max(max, series);
        }

        return max;
    }
}
