public class Bob {
    String hey(String pharse) {
        pharse = pharse.replaceAll("\\s", "");

        if (pharse.matches("[^a-z]*[A-Z]+\\?")) {
            return "Calm down, I know what I'm doing!";
        }

        if (pharse.matches(".*\\?")) {
            return "Sure.";
        }

        if (pharse.matches("[^a-z]*[A-Z]+[^a-z]*")) {
            return "Whoa, chill out!";
        }

        return pharse.isEmpty() ? "Fine. Be that way!" : "Whatever.";
    }
}

