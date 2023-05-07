import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeerSong {
    private static final String VERSE_TEMPLATE = """
            %s bottle%s of beer on the wall, %s bottle%s of beer.
            Take %s down and pass it around, %s bottle%s of beer on the wall.\n
            """;
    private static final String ZERO_BOTTLES_VERSE = """
            No more bottles of beer on the wall, no more bottles of beer.
            Go to the store and buy some more, 99 bottles of beer on the wall.\n
            """;

    String sing(int bottles, int verses) {
        return IntStream.range(0, verses).mapToObj(bottle -> getVerse(bottles - bottle)).collect(Collectors.joining());
    }

    String singSong() {
        return sing(99, 100);
    }

    private static String getVerse(int bottles) {
        return switch (bottles) {
            case 0 -> ZERO_BOTTLES_VERSE;
            case 1 -> String.format(VERSE_TEMPLATE, bottles, "", bottles, "", "it", "no more", "s");
            default ->
                    String.format(VERSE_TEMPLATE, bottles, "s", bottles, "s", "one", bottles - 1, bottles == 2 ? "" : "s");
        };
    }
}
