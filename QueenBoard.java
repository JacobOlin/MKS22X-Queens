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

  private boolean addQueen(int r, int c) {
    if(board[r][c] > 0) {
      return false;
    }
    board[r][c] = -1;
    for (int i = 1;i < board[r].length - c;i += 1) {
      board[r][c + i] += 1;
      if (r - i > 0 ){
        board[r - i][c + i] += 1;
      }
      if (r + i < board.length) {
        board[r + 1][c + 1] += 1;
      }
    }
    return true;
  }

  private boolean removeQueen(int r, int c) {
    if (board[r][c] >= 0) {
      return false;
    }
    board[r][c] = 0;
    for (int i = c + 1;i < board[r].length;i += 1) {
      board[r][c] -= 1;
    }
    return true;
  }
}
