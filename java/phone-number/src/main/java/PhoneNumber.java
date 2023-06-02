public class PhoneNumber {
    private final String phoneNumber;

    public PhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        } else if (phoneNumber.length() == 11 && !phoneNumber.startsWith("1")) {
            throw new IllegalArgumentException("11 digits must start with 1");
        } else if (extractDigits(phoneNumber).length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        } else if (phoneNumber.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        } else if (extractDigits(phoneNumber).length() == 11 && extractDigits(phoneNumber).matches(".0.*")) {
            throw new IllegalArgumentException("area code cannot start with zero");
        } else if (extractDigits(phoneNumber).length() == 11 && extractDigits(phoneNumber).matches(".1.*")) {
            throw new IllegalArgumentException("area code cannot start with one");
        } else if (extractDigits(phoneNumber).length() == 10 && extractDigits(phoneNumber).matches("0.*")) {
            throw new IllegalArgumentException("area code cannot start with zero");
        } else if (extractDigits(phoneNumber).length() == 10 && extractDigits(phoneNumber).matches("1.*")) {
            throw new IllegalArgumentException("area code cannot start with one");
        } else if (extractDigits(phoneNumber).matches(".{3,4}0.*")) {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        } else if (extractDigits(phoneNumber).matches(".{3,4}1.*")) {
            throw new IllegalArgumentException("exchange code cannot start with one");
        } else if (phoneNumber.matches(".*@.*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        this.phoneNumber = extractDigits(phoneNumber);
    }

    public String getNumber() {
        if (phoneNumber.length() == 11 && phoneNumber.startsWith("1")) {
            return phoneNumber.substring(1);
        }

        return phoneNumber;
    }

    private static String extractDigits(String phoneNumber) {
        return phoneNumber.replaceAll("\\D", "");
    }
}
