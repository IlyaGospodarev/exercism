import java.util.stream.IntStream;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        if (number <= 0) throw new IllegalArgumentException("You must supply a natural number (positive integer)");

        this.number = number;
    }

    public Classification getClassification() {
        if (number == 1) return Classification.DEFICIENT;

        int determineNumber = IntStream
                .range(1, number)
                .filter(i -> number % i == 0)
                .reduce(Integer::sum)
                .getAsInt();

        if (determineNumber == number) return Classification.PERFECT;
        else if (determineNumber > number) return Classification.ABUNDANT;
        else return Classification.DEFICIENT;
    }
}
