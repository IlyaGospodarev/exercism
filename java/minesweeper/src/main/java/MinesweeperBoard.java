import java.util.Arrays;
import java.util.List;

public class MinesweeperBoard {
    public static void main(String[] args) {
        List<String> inputBoard = Arrays.asList(
                " ",
                "*",
                " ",
                "*",
                " "
        );

        System.out.println(inputBoard);
    }
    private List<String> inputBoard;

    public MinesweeperBoard(List<String> inputBoard) {
        this.inputBoard = inputBoard;
    }


    public List<String> withNumbers() {
        return null;
    }
}
