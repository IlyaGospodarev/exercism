class WordProblemSolver {
    int solve(final String wordProblem) throws IllegalArgumentException {
        if (wordProblem.replaceAll("\\D", "").length() == 0 || wordProblem.contains("cubed")) {
            throwInvalidInputException();
        }

        if (wordProblem.matches("What is \\d+\\?")) {
            return Integer.parseInt(wordProblem.replaceAll("\\D", ""));
        }

        String[] wordSubstring = extractWordSubstring(wordProblem);

        if (isInvalidExpression(wordSubstring)) {
            throwInvalidInputException();
        }

        int result = extractNumber(wordSubstring[0]);

        for (int i = 1; i < wordSubstring.length; i += 2) {
            String operator = wordSubstring[i];
            int number = extractNumber(wordSubstring[i + 1]);

            switch (operator) {
                case "plus" -> result += number;
                case "minus" -> result -= number;
                case "multiplied" -> result *= number;
                case "divided" -> result /= number;
            }
        }

        return result;
    }

    private void throwInvalidInputException() throws IllegalArgumentException {
        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
    }

    private int extractNumber(String substring) {
        return substring.startsWith("-") ? -Integer.parseInt(substring.substring(1))
                : Integer.parseInt(substring);
    }

    private String[] extractWordSubstring(String wordProblem) {
        return wordProblem
                .substring(8)
                .replaceAll("by ", "")
                .replaceAll("\\?", "")
                .split(" ");
    }

    private boolean isInvalidExpression(String[] wordSubstring) {
        return wordSubstring.length % 2 == 0
                || wordSubstring[0].matches("\\D+")
                || wordSubstring[wordSubstring.length - 1].matches("\\D+");
    }
}
