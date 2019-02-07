public class QueenBoard{
  private int[][]board;

  public QueenBoard(int size) {
    board = new int[size][size];
    for (int i = 0;i < size;i += 1) {
      for (int j = 0;j < size;j += 1) {
        board[i][j] = 0;
      }
    }
  }
}
