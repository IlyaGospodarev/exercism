import java.util.*;

class DiamondPrinter {
    List<String> printToList(char a) {
        List<String> diamond = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int size = (a - 'A') * 2 + 1;
        int midIndex = size / 2;
        char currentChar = 'A';

        for (int i = 0; i < midIndex + 1; i++) {
            sb.setLength(0);

            for (int j = 0; j < size; j++) {
                if (j == midIndex - i || j == midIndex + i) {
                    sb.append(currentChar);
                } else {
                    sb.append(" ");
                }
            }

            diamond.add(sb.toString());
            currentChar++;
        }

        for (int i = diamond.size() - 2; i >= 0; i--) {
            diamond.add(diamond.get(i));
        }

        return diamond;
    }
}