import java.util.LinkedList;
import java.util.List;

class Series {
    public static void main(String[] args) {
        Series series = new Series("49142");
        System.out.println(series.slices(3));
    }

    private String string;

    Series(String string) {
        this.string = string;
    }

    List<String> slices(int num) throws IllegalArgumentException {
        if (num > string.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        } else if (num <= 0) {
            throw new IllegalArgumentException("Slice size is too small.");
        }

        List<String> list = new LinkedList<>();

        for (int i = 0; i <= string.length() - num; i++) {
            list.add(string.substring(i, i + num));
        }

        return list;
    }
}
