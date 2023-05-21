import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {
    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        Set<Integer> setsItem = new HashSet<>();

        for (int item : set) {
            for (int i = item; i <= number; i++) {
                if (i % item == 0) {
                    setsItem.add(i);
                }
            }
        }

        return setsItem.stream().reduce(Integer::sum).get();
    }
}
