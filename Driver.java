public class Driver {
  public static void main (String [] args) {
    /*
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

    /*
    for (int x = 1; x <= 10; x ++) {
      QueenBoard testing = new QueenBoard (x);
      System.out.println (x + ": " + testing.solve ());
      System.out.println (testing.toString ());
    }
    */

    /*
    for (int x = 1; x <= 10; x ++) {
      QueenBoard testing = new QueenBoard (x);
      System.out.println (x + ": " + testing.countSolutions ());
    }
    */
    QueenBoard a = new QueenBoard (2);
    System.out.println (a.countSolutions());
    QueenBoard b = new QueenBoard (5);
    System.out.println (b.countSolutions());
    QueenBoard c = new QueenBoard (10);
    System.out.println (c.countSolutions());
    QueenBoard t = new QueenBoard (1);
    System.out.println (t.countSolutions());
  }
}
