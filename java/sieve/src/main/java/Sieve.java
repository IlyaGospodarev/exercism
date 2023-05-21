import java.util.LinkedList;
import java.util.List;

class Sieve {
    private int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new LinkedList<>();

        for (int i = 2; i <= maxPrime; i++) {
            boolean isPrime = true;

            for (int j = i - 1; j >= 2; j--) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }
}
