public class Transpose {
    public static void main(String[] args) {
        Transpose transpose = new Transpose();

        System.out.println(transpose.transpose("ABC\n" + "123"));
    }


    public String transpose(String toTranspose) {
        StringBuilder transposedText = new StringBuilder();
        String[] lines = toTranspose.split("\n");

        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (String line : lines) {
                if (i < line.length()) {
                    transposedText.append(line.charAt(i));
                } else {
                    transposedText.append(" ");
                }
            }
            transposedText.append("\n");
        }

        return transposedText.toString().stripTrailing();
    }
}
