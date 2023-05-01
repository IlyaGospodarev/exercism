import java.util.Arrays;

class ArmstrongNumbers {
    boolean isArmstrongNumber(int numberToCheck) {
        int lengthOfNumber = String
                .valueOf(numberToCheck)
                .length();

        return Arrays.stream(String.valueOf(numberToCheck).split(""))
                .map(s -> (int) Math.pow(Double.parseDouble(s), lengthOfNumber))
                .reduce(Integer::sum)
                .get() == numberToCheck;
    }
}
