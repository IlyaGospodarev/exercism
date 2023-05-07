import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House {
    private final String[] lines =new String[]{"",
            " that lay in ",
            " that ate ",
            " that killed ",
            " that worried ",
            " that tossed ",
            " that milked ",
            " that kissed ",
            " that married ",
            " that woke ",
            " that kept ",
            " that belonged to "
    };

    private final String[] versesLine = new String[]{
            "the house that Jack built.",
            "the malt",
            "the rat",
            "the cat",
            "the dog",
            "the cow with the crumpled horn",
            "the maiden all forlorn",
            "the man all tattered and torn",
            "the priest all shaven and shorn",
            "the rooster that crowed in the morn",
            "the farmer sowing his corn",
            "the horse and the hound and the horn"
    };

    public String sing() {
        return verses(1, 12);
    }

    public String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }

    public String verse(int verseNumber) {
        return verseNumber == 1 ? "This is the house that Jack built." : generateVerse(verseNumber);
    }

    private String generateVerse(int verseNumber) {
        return "This is ".concat(IntStream.rangeClosed(1, verseNumber)
                .mapToObj(i -> versesLine[verseNumber - i].concat(lines[verseNumber - i]))
                .collect(Collectors.joining()));
    }
}
