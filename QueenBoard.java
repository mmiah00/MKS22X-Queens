public class QueenBoard {
  private int[][]board;

  public QueenBoard(int size){
    board = new int [size][size];
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c ++) {
        board [r][c] = 0;
      }
    }
  }

  private boolean addQueen(int x, int y) {
    if (x < board[0].length && y < board.length && x >=0 && y >= 0 && board[y][x] > -1 ) {
      board [y][x] = -1;
      return true;
    }
    return false;
  }

  private void xHorizontal (int x, int y) {
    int temp = 0;
    while (temp < board.length) {
      board [y][temp] += 1;
      temp ++;
    }
  }

  private void xVertical (int x, int y) {
    int temp = 0;
    while (temp < board.length) {
      board [temp][x] += 1;
      temp ++;
    }
  }

  private void xDiagonal (int x, int y) {
    while (x < board[0].length && y < board.length) {
      board[y][x] += 1;
      x ++;
      y ++;
    }
  }

  private boolean removeQueen(int x, int y) {
    if (x < board[0].length && y < board.length && x >= 0 && y >= 0 && board[y][x] == -1) {
      board [y][x] = 0;
      return true;
    }
    return false;
  }
    /**
    *@return The output string formatted as follows:
    *All numbers that represent queens are replaced with 'Q'
    *all others are displayed as underscores '_'
    *There are spaces between each symbol:
    *"""_ _ Q _
    *Q _ _ _

    *_ _ _ Q

    *_ Q _ _"""
    *(pythonic string notation for clarity,
    *excludes the character up to the *)
    */
  public String toString(){
    String ans = "";
    for (int c = 0; c < board.length; c ++){
      for (int r = 0; r < board[0].length; r ++) {
        if (board [c][r] == -1) {
          if (r == board[0].length - 1 ) {
            ans += "Q\n";
          }
          else {
            ans += "Q ";
          }
        }
        else {
          if (r == board[0].length - 1 ) {
            ans += "_\n";
          }
          else {
            ans += "_ ";
          }
        }
      }
    }
    return ans;
  }



    /**
    *@return false when the board is not solveable and leaves the board filled with zeros;

    *        true when the board is solveable, and leaves the board in a solved state

    *@throws IllegalStateException when the board starts with any non-zero value

    */
  public boolean solve() throws IllegalStateException {
    if (this.solvable (0,0)) {
      return true;
    }
    else {
      for (int y = 0; y < board.length; y ++) {
        for (int x = 0; x < board[0].length; x ++) {
          board[y][x] = 0;
        }
      }
      return false;
    }
  }

  public boolean solvable (int x, int y) {
    return true;
  }

    /**
    *@return the number of solutions found, and leaves the board filled with only 0's
    *@throws IllegalStateException when the board starts with any non-zero value
    */
  public int countSolutions() throws IllegalStateException{
    return 1;
  }


}
