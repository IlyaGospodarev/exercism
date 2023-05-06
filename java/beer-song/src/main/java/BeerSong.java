import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeerSong {
    public static void main(String[] args) {

    }

    String sing(int numberOfBottles, int bottlesToTake) {

//        if (numberOfBottles == 2) {
//            return IntStream.range(0, bottlesToTake)
//                    .mapToObj(s -> String.format("%1$d bottles of beer on the wall, %d bottles of beer.\n", numberOfBottles - s)
//                            .concat(String.format("Take one down and pass it around, %d bottle of beer on the wall.\n\n", numberOfBottles - (s + 1))))
//                    .collect(Collectors.joining());
//        } else if (numberOfBottles == 1) {
//            return IntStream.range(0, bottlesToTake)
//                    .mapToObj(s -> String.format("%1$d bottle of beer on the wall, %d bottle of beer.\n", numberOfBottles - s)
//                            .concat(String.format("Take it down and pass it around, no more bottles of beer on the wall.\n\n", numberOfBottles - (s + 1))))
//                    .collect(Collectors.joining());
//        }
//
//        if (numberOfBottles < bottlesToTake) {
//            return IntStream.range(0, bottlesToTake)
//                    .mapToObj(s -> String.format("No more bottles of beer on the wall, no more bottles of beer.\n")
//                            .concat(String.format("Go to the store and buy some more, 99 bottles of beer on the wall.\n\n")))
//                    .collect(Collectors.joining());
//        }

        return IntStream.range(0, bottlesToTake)
                .mapToObj(s -> String.format("%1$d bottles of beer on the wall, %d bottles of beer.\n", numberOfBottles - s)
                        .concat(String.format("Take one down and pass it around, %d bottles of beer on the wall.\n\n", numberOfBottles - (s + 1))))
                .collect(Collectors.joining());
    }

    String singSong() {
        return sing(99, 100);
    }
}
