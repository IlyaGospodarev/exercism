public class QueenAttackCalculator {
    private final Queen whiteQueen;
    private final Queen blackQueen;

    public QueenAttackCalculator(Queen whiteQueen, Queen blackQueen) throws IllegalArgumentException {
        if (whiteQueen == null || blackQueen == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        } else if (whiteQueen.row() == blackQueen.row() && whiteQueen.column() == blackQueen.column()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }

        this.whiteQueen = whiteQueen;
        this.blackQueen = blackQueen;
    }

    public boolean canQueensAttackOneAnother() {
        int wRow = whiteQueen.row();
        int wColumn = whiteQueen.column();
        int bRow = blackQueen.row();
        int bColumn = blackQueen.column();

        int rowDiff = Math.abs(wRow - bRow);
        int columnDiff = Math.abs(wColumn - bColumn);

        return wRow == bRow || wColumn == bColumn || rowDiff == columnDiff;
    }
}

record Queen(int row, int column) {
    Queen {
        if (row < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        } else if (row > 7) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        } else if (column < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        } else if (column > 7) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }
    }
}
