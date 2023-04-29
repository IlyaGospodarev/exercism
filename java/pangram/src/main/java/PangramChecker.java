import java.util.*;
import java.util.stream.Collectors;

public class PangramChecker {
    public static void main(String[] args) {
        PangramChecker checker = new PangramChecker();
        System.out.println(checker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
    }

    public boolean isPangram(String input) {
        if (input.isBlank()) {
            return false;
        }

        Set<String> inputString = Arrays
                .stream(input
                        .toLowerCase()
                        .replaceAll("[\\W\\d_]", "")
                        .trim()
                        .split(""))
                .collect(Collectors.toSet());

        return inputString.size() == 26;
    }
}
