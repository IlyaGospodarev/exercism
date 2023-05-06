public class Bob {
    String hey(String phrase) {
        phrase = phrase.trim();

        if (phrase.isEmpty()) {
            return "Fine. Be that way!";
        } else if (phrase.equals(phrase.toUpperCase()) && !phrase.equals(phrase.toLowerCase())) {
            if (phrase.endsWith("?")) {
                return "Calm down, I know what I'm doing!";
            } else {
                return "Whoa, chill out!";
            }
        } else if (phrase.endsWith("?")) {
            return "Sure.";
        } else {
            return "Whatever.";
        }
    }
}
