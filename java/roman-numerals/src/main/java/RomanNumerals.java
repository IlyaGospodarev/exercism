public class RomanNumerals {
    private int number;
    private final int[] digits = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public RomanNumerals(int number) {
        this.number = number;
    }

    public String getRomanNumeral() {
        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            while (number >= digits[i]) {
                number -= digits[i];
                romanNumber.append(letters[i]);
            }
        }

        return romanNumber.toString();
    }
}