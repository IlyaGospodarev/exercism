import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {
    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length == 0) {
            return "";
        }

        return IntStream.range(0, words.length - 1)
                .mapToObj(i -> String.format("For want of a %s the %s was lost.\n", words[i], words[i + 1]))
                .collect(Collectors.joining()).concat("And all for the want of a " + words[0] + ".");
    }
}
