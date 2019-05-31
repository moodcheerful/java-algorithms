import java.util.Arrays;

public class GameOfLife {

    private boolean[][] board;

    public GameOfLife(boolean[][] input) {
        this.board = input;
    }

    public boolean isInBound(int i, int j) {
        return board.length == 0 || i >= board.length || i < 0 || j < 0 || j >= board[0].length
                ? false : true;
    }

    public boolean isAlive(int i, int j) {
        return isInBound(i, j) ? board[i][j] : false;
    }

    public int countNeighbors(int i, int j) {
        int count = 0;
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (isAlive(i + row, j + col) && !(row == 0 && col == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean nextCellState(int i, int j) {
        return (isAlive(i, j) && countNeighbors(i, j) == 2) || countNeighbors(i, j) == 3;
    }

    public boolean[][] transform() {
        boolean[][] result = new boolean[board.length][board[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = nextCellState(i, j);
            }
        }
        return result;
    }

    // Using streams.
    public int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int countNeighbors2(int i, int j) {
        return (int) Arrays.asList(dirs).stream().filter(dir -> isAlive(i + dir[0], j + dir[1])).count();
    }
}
