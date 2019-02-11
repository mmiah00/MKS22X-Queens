public class Driver {
  public static void main (String [] args) {
    QueenBoard testing = new QueenBoard (5);
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
  }
}
