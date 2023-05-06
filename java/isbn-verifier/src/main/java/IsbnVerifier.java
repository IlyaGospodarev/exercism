class IsbnVerifier {
     boolean isValid(String stringToVerify) {
        String checkNumber = stringToVerify.replaceAll("-", "");

        if (checkNumber.length() != 10) {
            return false;
        }

        int multiplier = 10;
        int isIsbn = 0;

        String[] strings = checkNumber.split("");

        for (int i = 0; i < strings.length; i++) {
            if (checkNumber.endsWith("X")) {
                strings[strings.length - 1] = "10";
            }

            if (strings[i].matches("[A-Z]")) {
                return false;
            }

            isIsbn += Integer.parseInt(strings[i]) * multiplier;
            multiplier--;
        }

        return isIsbn % 11 == 0;
    }
}
