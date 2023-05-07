import java.util.stream.IntStream;

class IsbnVerifier {
    boolean isValid(String isbn) {
        String numeric = isbn.replace("-", "");
        int isbnLength = numeric.length();

        if (numeric.matches("\\d{9,10}X?")) {
            return IntStream.range(0, isbnLength)
                    .map(i -> (numeric.charAt(i) == 'X' ? 10 : numeric.charAt(i) - '0') * (isbnLength - i))
                    .sum() % 11 == 0;
        } else return false;
    }
}
