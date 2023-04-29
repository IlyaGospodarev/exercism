import java.util.stream.Collectors;

class RotationalCipher {
    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars()
            .mapToObj(this::rotate)
            .map(Object::toString)
            .collect(Collectors.joining());
    }

    private Character rotate(int ch) {
        if (Character.isAlphabetic(ch)) {
            char start = Character.isUpperCase(ch) ? 'A' : 'a';
            ch = (ch - start + shiftKey) % 26 + start;
        }
        return (char) ch;
    }
}
