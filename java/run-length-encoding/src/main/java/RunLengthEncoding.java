public class RunLengthEncoding {
    public String encode(String phrase) {
        if (phrase.isEmpty()) {
            return "";
        }

        StringBuilder encodePhrase = new StringBuilder();
        int counter = 1;

        for (int i = 0; i <= phrase.length() - 1; i++) {
            if (i == phrase.length() - 1) {
                encodePhrase.append(counter > 1 ? counter : "")
                        .append(phrase.charAt(phrase.length() - 1));
            } else if (phrase.charAt(i) == phrase.charAt(i + 1)) {
                counter++;
            } else {
                encodePhrase.append(counter > 1 ? counter : "").append(phrase.charAt(i));
                counter = 1;
            }
        }

        return encodePhrase.toString();
    }

    public String decode(String phrase) {
        StringBuilder decodePhrase = new StringBuilder();
        int number = 0;

        for (char letter : phrase.toCharArray()) {
            if (Character.isDigit(letter)) {
                number = number * 10 + (letter - '0');
            } else {
                do {
                    decodePhrase.append(letter);
                    number--;
                } while (number > 0);

                number = 0;
            }
        }

        return decodePhrase.toString();
    }
}