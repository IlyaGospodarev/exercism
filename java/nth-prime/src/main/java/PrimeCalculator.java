import java.util.stream.IntStream;

class PrimeCalculator {
    int nth(int nth) throws IllegalArgumentException {
        if (nth <= 0) {
            throw new IllegalArgumentException();
        }

        int nthPrime = 0;
        int firstPrime = 2;

        while (nth > 0) {
            int currentPrime = firstPrime;
            boolean isPrime = IntStream.rangeClosed(2, firstPrime / 2).noneMatch(i -> currentPrime % i == 0);

            if (isPrime) {
                nthPrime = firstPrime;
                nth--;
            }

            firstPrime += 1;
        }

        return nthPrime;
    }

}
