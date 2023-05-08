class LuhnValidator {
    boolean isValid(String candidate) {
        String numberWithoutSpaces = candidate.replace(" ", "");

        return numberWithoutSpaces.matches("([0-9]{2,})|[1-9]")
                && applyLuhnAlgorithm(numberWithoutSpaces);
    }

    private static boolean applyLuhnAlgorithm(String candidate) {
        StringBuilder sb = new StringBuilder(candidate);

        for (int i = sb.length() - 2; i >= 0; i -= 2) {
            int digit = Character.digit(sb.charAt(i), 10);
            digit *= 2;
            if (digit > 9) {
                digit -= 9;
            }
            sb.setCharAt(i, Character.forDigit(digit, 10));
        }

        return sb.chars().map(Character::getNumericValue).sum() % 10 == 0;
    }
}
