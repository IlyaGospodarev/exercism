public class Robot {
    GridPosition initialGridPosition;
    Orientation initialOrientation;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.initialGridPosition = initialGridPosition;
        this.initialOrientation = initialOrientation;
    }

    public void turnRight() {
        switch (initialOrientation) {
            case NORTH -> initialOrientation = Orientation.EAST;
            case EAST -> initialOrientation = Orientation.SOUTH;
            case SOUTH -> initialOrientation = Orientation.WEST;
            case WEST -> initialOrientation = Orientation.NORTH;
        }
    }

    public void turnLeft() {
        switch (initialOrientation) {
            case NORTH -> initialOrientation = Orientation.WEST;
            case EAST -> initialOrientation = Orientation.NORTH;
            case SOUTH -> initialOrientation = Orientation.EAST;
            case WEST -> initialOrientation = Orientation.SOUTH;
        }
    }

    public void advance() {
        switch (initialOrientation) {
            case NORTH -> initialGridPosition = new GridPosition(initialGridPosition.x, initialGridPosition.y + 1);
            case EAST -> initialGridPosition = new GridPosition(initialGridPosition.x + 1, initialGridPosition.y);
            case SOUTH -> initialGridPosition = new GridPosition(initialGridPosition.x, initialGridPosition.y - 1);
            case WEST -> initialGridPosition = new GridPosition(initialGridPosition.x - 1, initialGridPosition.y);
        }
    }

    public void simulate(String instructions) {
        char[] letters = instructions.toCharArray();

        for (char letter : letters) {
            switch (letter) {
                case 'R' -> turnRight();
                case 'L' -> turnLeft();
                case 'A' -> advance();
            }
        }
    }

    public Orientation getOrientation() {
        return initialOrientation;
    }

    public GridPosition getGridPosition() {
        return initialGridPosition;
    }
}
