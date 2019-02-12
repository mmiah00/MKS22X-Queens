public class QueenBoard {
  private int[][]board;

  public QueenBoard(int size){
    board = new int [size][size];
    reset ();
  }

  private void reset () {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[0].length; x++) {
        board[y][x] = 0;
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



  private boolean empty () {
    for (int y = 0; y < board.length; y ++) {
      for (int x = 0; x < board[0].length; x ++) {
        if (board[y][x] != 0) {
          return false;
        }
      }
    }
    return true;
  }

    /**
    *@return false when the board is not solveable and leaves the board filled with zeros;

    *        true when the board is solveable, and leaves the board in a solved state

    *@throws IllegalStateException when the board starts with any non-zero value

    */

    public boolean solve(){
    if (!empty ()) {
      throw new IllegalStateException (); // through exception if board starts with any non-zero values
    }
    if (solvable (0)) {
      return true;
    }
    else {
      this.reset ();
      return false;
    }
  }

  private boolean solvable (int col) {
    if (col >= board[0].length) { //if reaches the end of the board
      return true; //return true
    }
    else {
      for (int r = 0; r < board.length; r ++) { //go through each row
        if (addQueen (col,r)) { //if you can add the queen
          if (solvable (col + 1)) { //check next column
            return true;
          }
          removeQueen (col,r); //remove queen afterwards
        }
      }
    }
    return false; //else return false
  }

    /**
    *@return the number of solutions found, and leaves the board filled with only 0's
    *@throws IllegalStateException when the board starts with any non-zero value
    */

  public int countSolutions(){
    if (!empty ()) {
      throw new IllegalStateException (); // through exception if board starts with any non-zero values
    }
    int ans = counter (0);
    this.reset ();
    return ans;
  }

  private int counter (int col) {
    if (board.length < 2 ) { //if size is 0 or 1 there is one solution
      return 1;
    }
    if (col >= board[0].length) {
      return 1; //if col reaches the end, return 1
    }
    else {
      int sum = 0; //num solutions
      for (int r = 0; r < board.length; r ++) { //going through each row
        if (addQueen (col,r)) { //if you can add the queen
          sum += counter (col + 1); //add to sum
          removeQueen (col,r); //then remove queen
        }
      }
      return sum; //at end return the sum
    }
    /*
    if (col >= board[0].length) {
      return sum;
    }
    for (int r = 0; r < board.length; r ++) {
      if (addQueen (col,r)) {
        sum += 1;
      }
      removeQueen (col, r);
      //return counter (col + 1, sum);
    }
    return counter (col + 1, sum);
    */
  }


}
