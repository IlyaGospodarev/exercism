import java.util.*;
import java.util.stream.IntStream;


public class PhoneNumber {
    public static void main(String[] args) {
        PhoneNumber number = new PhoneNumber("123-abc-7890");

    }


    private String phoneNumber;

    public PhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        } else if (phoneNumber.length() == 11 && !phoneNumber.startsWith("1")) {
            throw new IllegalArgumentException("11 digits must start with 1");
        } else if (phoneNumber.matches("[^\\d*\\W]")) {
            throw new IllegalArgumentException("letters not permitted");
        }

        this.phoneNumber = phoneNumber.replaceAll("[\\D]", "");
    }

    public String getNumber() {

        if (phoneNumber.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }

        System.out.println(phoneNumber);
        return phoneNumber;
    }
}
