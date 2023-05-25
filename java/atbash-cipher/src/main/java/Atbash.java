import java.util.stream.Collectors;

public class Atbash {
    public String encode(String phrase) {
        return phrase.replaceAll("\\W", "")
                .toLowerCase()
                .chars()
                .mapToObj(this::getCipher)
                .collect(Collectors.joining())
                .replaceAll("(.{5})", "$1 ")
                .trim();
    }

    public String decode(String phrase) {
        return phrase.replaceAll("\\W", "")
                .chars()
                .mapToObj(this::getCipher)
                .collect(Collectors.joining());
    }

    private String getCipher(int letter) {
        if (Character.isLetter(letter)) {
            int index = letter - 'a';
            return String.valueOf((char) ('z' - index));
        }

        return String.valueOf((char) letter);
    }
}