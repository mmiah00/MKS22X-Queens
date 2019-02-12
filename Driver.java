public class Driver {
  public static void main (String [] args) {
    /* TESTING ADD AND REMOVE QUEEN
    testing.addQueen(1,3);
    System.out.println (testing.testString ());
    testing.removeQueen(1,3);
    System.out.println (testing.testString ());
    testing.addQueen(11,3);
    System.out.println (testing.testString ());
    testing.addQueen(1,2);
    System.out.println (testing.testString ());
    testing.addQueen(1,3);
    System.out.println (testing.testString ());
    */


    System.out.println ("Size\tSolvable?");
    for (int x = 1; x < 15; x ++) {
      QueenBoard testing = new QueenBoard (x);
      System.out.println (x + "\t" + testing.solve ());
    }

    for (int x = 1; x < 15; x ++) {
      QueenBoard testing = new QueenBoard (x);
      System.out.println (x + ": " + testing.countSolutions ());
    }
  }
}
