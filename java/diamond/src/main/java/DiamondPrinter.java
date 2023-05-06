import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {
    public static void main(String[] args) {
        DiamondPrinter diamondPrinter = new DiamondPrinter();
        System.out.println(diamondPrinter.printToList('C'));
    }

    List<String> printToList(char a) {
        List<String> printList = new ArrayList<>();
        int sumOfLetter = a - 'A';
        StringBuilder sb = new StringBuilder();

        for (int i = 'A'; i <= a; i++) {

        }


//        sb.append("  A  ").append("\n").append(" B B ").append("\n");
//        StringBuilder sp = new StringBuilder(sb);
//        System.out.println(sb.append("C   C").append(sp.reverse()));

        return List.of(String.valueOf(a - 'A'));
    }
}
