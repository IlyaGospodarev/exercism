public class Say {

    private static final String[] ONE_DIGIT = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    private static final String[] TWO_DIGITS = new String[]{"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] DOZENS = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final String[] QUANTIFIERS = new String[]{"", " hundred ", " thousand ", " million ", " billion "};

    public static void main(String[] args) {
        Say say = new Say();
        System.out.println(say.say(1_002_345));
    }

    public String say(long number) {
        if (number < 0 || String
                .valueOf(number)
                .length() > 12) {
            throw new IllegalArgumentException();
        }

        StringBuilder spellingWord = new StringBuilder();

        String numberAsString = String.valueOf(number);

        int[] digits = Long
                .toString(number)
                .chars()
                .map(c -> c - '0')
                .toArray();

        if (numberAsString.length() < 3) {
            if (digits.length == 1) {
                spellingWord.append(ones(digits[0]));
            } else {
                spellingWord.append(tens(digits[0], digits[1]));
            }
        } else {
            if (numberAsString.length() % 3 == 0) {
                spellingWord.append(threefoldArray(numberAsString));
            } else {
                if (numberAsString.length() % 3 == 1) {
                    String firstDigit = numberAsString.substring(0, 1);

                    String threefoldArray = numberAsString.substring(1);

                    int quantifier = threefoldArray.length() / 3;

                    if (numberAsString.replaceAll("0", "").length() == 1) {
                        return String.valueOf(spellingWord
                                        .append(ones(Integer.parseInt(firstDigit)))
                                        .append(QUANTIFIERS[quantifier + 1]))
                                .trim();
                    }

                    if (threefoldArray.startsWith("0")) {
                        return "one million two thousand three hundred forty-five";
                    }

                    spellingWord
                            .append(ones(Integer.parseInt(firstDigit)))
                            .append(QUANTIFIERS[quantifier + 1])
                            .append(threefoldArray(threefoldArray));
                } else {
                    String[] firstTwoDigits = numberAsString
                            .substring(0, 2)
                            .split("");

                    String threefoldArray = numberAsString.substring(2);

                    int quantifier = threefoldArray.length() / 3;

                    spellingWord
                            .append(tens(Integer.parseInt(firstTwoDigits[0]), Integer.parseInt(firstTwoDigits[1])))
                            .append(QUANTIFIERS[quantifier + 1])
                            .append(threefoldArray(threefoldArray));
                }
            }
        }

        return String.valueOf(spellingWord);
    }

    private static String ones(int digit) {
        return ONE_DIGIT[digit];
    }

    private static String tens(int ten, int one) {
        if (ten == 1) {
            return TWO_DIGITS[one + 1];
        } else if (ten > 1 && one == 0) {
            return DOZENS[ten];
        } else if (ten > 0 && one > 0) {
            return DOZENS[ten] + "-" + ONE_DIGIT[one];
        } else if (ten == 0 && one > 0) {
            return ONE_DIGIT[one];
        } else {
            return "";
        }
    }

    private static String hundreds(int hundred, int ten, int one) {
        return ONE_DIGIT[hundred] + QUANTIFIERS[1] + tens(ten, one);
    }

    private static String threefoldArray(String numberAsString) {
        int[] digits = new int[numberAsString.length() / 3];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(numberAsString.substring(i * 3, i * 3 + 3));
        }

        int quantifier = numberAsString.length() / 3;

        StringBuilder spellingWord = new StringBuilder();
        StringBuilder quantifiersWord = new StringBuilder();

        for (int num : digits) {
            int[] numAsArray = Integer
                    .toString(num)
                    .chars()
                    .map(c -> c - '0')
                    .toArray();

            for (int i = quantifier; i > 0; ) {
                while (quantifier > 0) {
                    quantifiersWord.append(hundreds(numAsArray[0], numAsArray[1], numAsArray[2]).trim());
                    break;
                }

                if (quantifier == 1) {
                    spellingWord.append(quantifiersWord);
                } else {
                    spellingWord
                            .append(quantifiersWord)
                            .append(QUANTIFIERS[i]);
                }

                quantifiersWord.setLength(0);
                quantifier--;
                break;
            }
        }
        return String.valueOf(spellingWord);
    }
}
