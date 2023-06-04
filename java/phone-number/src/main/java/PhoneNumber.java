public class PhoneNumber {
    private final String phoneNumber;

    public PhoneNumber(String phoneNumber) throws IllegalArgumentException {
        String digitsNumber = extractDigits(phoneNumber);

        if (phoneNumber.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        } else if (phoneNumber.matches(".*@.*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        } else if (digitsNumber.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        } else if (digitsNumber.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        } else if (digitsNumber.matches(".{3,4}0.*")) {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        } else if (digitsNumber.matches(".{3,4}1.*")) {
            throw new IllegalArgumentException("exchange code cannot start with one");
        } else if (digitsNumber.length() == 11 && !digitsNumber.startsWith("1")) {
            throw new IllegalArgumentException("11 digits must start with 1");
        }  else if (digitsNumber.matches("1?0.*")) {
            throw new IllegalArgumentException("area code cannot start with zero");
        } else if (digitsNumber.matches("^11.{9}$|^1.{9}$")) {
            throw new IllegalArgumentException("area code cannot start with one");
        }


//        else if (digitsNumber.length() == 11 && !digitsNumber.startsWith("1")) {
//            throw new IllegalArgumentException("11 digits must start with 1");
//        } else if (digitsNumber.length() == 11 && digitsNumber.matches("10.*")) {
//            throw new IllegalArgumentException("area code cannot start with zero");
//        } else if (digitsNumber.length() == 11 && digitsNumber.matches("11.*")) {
//            throw new IllegalArgumentException("area code cannot start with one");
//        } else if (digitsNumber.length() == 10 && digitsNumber.matches("0.*")) {
//            throw new IllegalArgumentException("area code cannot start with zero");
//        } else if (digitsNumber.length() == 10 && digitsNumber.matches("1.*")) {
//            throw new IllegalArgumentException("area code cannot start with one");
//        } else if (digitsNumber.matches(".{3,4}0.*")) {
//            throw new IllegalArgumentException("exchange code cannot start with zero");
//        } else if (digitsNumber.matches(".{3,4}1.*")) {
//            throw new IllegalArgumentException("exchange code cannot start with one");
//        }

        this.phoneNumber = digitsNumber;
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
