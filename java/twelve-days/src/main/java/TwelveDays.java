import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {
    private final String[] days = new String[]{
            "first",
            "second",
            "third",
            "fourth",
            "fifth",
            "sixth",
            "seventh",
            "eighth",
            "ninth",
            "tenth",
            "eleventh",
            "twelfth"};

    private final String[] presents = new String[]{
            "a Partridge in a Pear Tree.\n",
            "two Turtle Doves, and ",
            "three French Hens, ",
            "four Calling Birds, ",
            "five Gold Rings, ",
            "six Geese-a-Laying, ",
            "seven Swans-a-Swimming, ",
            "eight Maids-a-Milking, ",
            "nine Ladies Dancing, ",
            "ten Lords-a-Leaping, ",
            "eleven Pipers Piping, ",
            "twelve Drummers Drumming, "};

    String verse(int verseNumber) {
        return String.format("On the %s day of Christmas my true love gave to me: ", days[verseNumber - 1])
                .concat(Arrays.stream(presents).limit(verseNumber).reduce((s, s2) -> s2 + s).get());
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse).mapToObj(this::verse).collect(Collectors.joining("\n"));
    }

    String sing() {
        return verses(1, 12);
    }
}
