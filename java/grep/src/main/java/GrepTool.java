import java.util.List;

public class GrepTool {
    private static int square(int n) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Recursive case
        else {
            return square(n-1) + (2 * n) - 1;
        }
    }
    public static void main( String args[] ) {
        int input = 6;
        int output = square(input);
        System.out.println("The square of the number " + input + " is: " + output);
    }

    public String grep(String agamemnon, List<Object> objects, List<String> strings) {
        return null;
    }
}
