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

  private boolean addQueen(int x, int y) { //checks if you can add a queen, sees if safe for queen to be placed at x, y
    if (x < board[0].length && y < board.length && x >=0 && y >= 0 && board[y][x] == 0 ) {
      if (this.eliminate (x, y,  1,  0) //for right of queen
          && this.eliminate (x, y, -1,  0) //for left of queen
          && this.eliminate (x, y,  0,  1) //for below queen
          && this.eliminate (x, y,  0, -1) //for above queen
          && this.eliminate (x, y,  1,  1) //for upper right corner
          && this.eliminate (x, y, -1, -1) //for lower right corner
          && this.eliminate (x, y, -1,  1) //for upper left corner
          && this.eliminate (x, y,  1, -1) /*for lower left corner*/) {
            board[y][x] = -1;
            return true;
          }
      else {
        return false;
      }
    }
    return false;
  }

  private boolean eliminate (int x, int y, int xinc, int yinc) {
    x += xinc;
    y += yinc;
    while (x < board[0].length && y < board.length && x > -1 && y > -1) {//xinc for left (-1) or right (1) and yinc for up (-1) and down (1)
      if (board[y][x] == -1) { //checks if there is a queen
        return false;
      }
      board[y][x] ++; //adding to number of squares in danger
      x += xinc; //moving right or left
      y += yinc; //moving up or down
    }
    return true;
  }

  private boolean removeQueen(int x, int y) {
    if (x < board[0].length && y < board.length && x >= 0 && y >= 0 && board[y][x] == -1) {
      this.recuperate (x + 1, y,  1,  0); //for right of queen
      this.recuperate (x - 1, y, -1,  0); //for left of queen
      this.recuperate (x, y + 1,  0,  1); //for below queen
      this.recuperate (x, y - 1,  0, -1); //for above queen
      this.recuperate (x + 1, y + 1,  1,  1); //for upper right corner
      this.recuperate (x - 1 , y - 1, -1, -1); //for lower right corner
      this.recuperate (x -1 , y + 1, -1,  1); //for upper left corner
      this.recuperate (x + 1, y - 1,  1, -1); //for lower left corner
      board[y][x] = 0;
      return true;
    }
    return false;
  }

  private void recuperate (int x, int y, int xinc, int yinc) { //xinc for left (-1) or right (1) and yinc for up (-1) and down (1)
    while (x < board[0].length && y < board.length && x > -1 && y > -1) {
      board[y][x] --; //subtracting from number of squares in danger
      x += xinc; //moving right or left
      y += yinc; //moving up or down
    }
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
            //ans += board[c][r] + "\n";
          }
          else {
            ans += "_ ";
            //ans += board[c][r] + "\n";
          }
        }
      }
    }
    return ans;
  }

  public String testString () { //to test addQueen and removeQueen
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
            //ans += "_\n";
            ans += board[c][r] + " \n";
          }
          else {
            //ans += "_ ";
            ans += board[c][r] + " ";
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
    if (solvable (0)) {
      return true;
    }
    else {
      for (int y = 0; y < board.length; y++) {
        for (int x = 0; x < board[0].length; x++) {
          board[y][x] = 0;
        }
      }
      return false;
    }
  }

  private boolean solvable (int col) {
    if (col >= board[0].length) {
      return true;
    }
    else {
      for (int r = 0; r < board.length; r ++) {
        if (addQueen (col,r)) {
          if (solvable (col + 1)) {
            return true;
          }
          removeQueen (col,r);
        }
      }
    }
    return false;
  }

    /**
    *@return the number of solutions found, and leaves the board filled with only 0's
    *@throws IllegalStateException when the board starts with any non-zero value
    */
  public int countSolutions() throws IllegalStateException{
    if (this.solve () == false) {
      return 0;
    }
    else {
      return counter (0,0);
    }
  }

  private int counter (int col, int sum) {
    if (col >= board.length) {
      return sum;
    }
    else {
      for (int r = 0; r < board.length; r ++) {
        if (addQueen (col, r)) {
          sum += 1;
        }
        return counter (col + 1, sum);
      }
    }
    return -1; 
  }


}
