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
        if (number == 1 || set.length == 0) {
            return 0;
        }

        Set<Integer> setsItem = new HashSet<>();

        for (int item : set) {
            if (item == 0) {
                break;
            }

            for (int i = item; i < number; i += item) {
                setsItem.add(i);
            }
        }

        return setsItem.stream().mapToInt(Integer::intValue).sum();
    }
}
