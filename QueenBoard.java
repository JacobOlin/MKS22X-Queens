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
      if (r - i >= 0 ){
        board[r - i][c + i] += 1;
      }
      if (r + i < board.length) {
        board[r + i][c + i] += 1;
      }
    }
    return true;
  }

  private boolean removeQueen(int r, int c) {
    if (board[r][c] >= 0) {
      return false;
    }
    board[r][c] = 0;
    for (int i = 1;i < board[r].length - c;i += 1) {
      board[r][c + i] -= 1;
      if (r - i >= 0 ){
        board[r - i][c + i] -= 1;
      }
      if (r + i < board.length) {
        board[r + i][c + i] -= 1;
      }
    }
    return true;
  }

  public String testToString() {
    String ans = "";
    for (int i = 0;i < board.length;i += 1) {
      for (int j = 0;j < board[i].length;j += 1) {
        if (board[i][j] == -1) {
          ans += "Q ";
        }
        else {
          ans += board[i][j] + " ";
        }
      }
      ans += "\n";
    }
    return ans;
  }

  public String toString() {
    String ans = "";
    for (int i = 0;i < board.length;i += 1) {
      for (int j = 0;j < board[i].length;j += 1) {
        if (board[i][j] == -1) {
          ans += "Q ";
        }
        else {
          ans += "_ ";
        }
      }
      ans += "\n";
    }
    return ans;
  }

  public boolean solve() {
    return helper(0);
  }

  private boolean helper(int col) {
    if (col >= board.length) {
      return true;
    }
    for (int r = 0;r < board.length;r += 1) {
      if (addQueen(r,col)) {
        if (helper(col+1)) {
          return true;
        }
        removeQueen(r,col);
      }
    }
    return false;
  }

}
