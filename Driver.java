public class Driver {
  public static void main (String [] args) {
    QueenBoard testing = new QueenBoard (8);
    System.out.println (testing.toString ());
    System.out.println (testing.addQueen (3,4));
    System.out.println (testing.addQueen (6,2));
    System.out.println (testing.addQueen (4,0));
    System.out.println (testing.addQueen (1,6));
    System.out.println (testing.toString());
    System.out.println (testing.removeQueen (6,2));
    System.out.println (testing.removeQueen (4,0));
    System.out.println (testing.toString ());
    System.out.println (testing.removeQueen (0,0));
    System.out.println (testing.removeQueen (-1, 10));
    System.out.println (testing.removeQueen (-3, 22));
    System.out.println (testing.addQueen (200,2));
    System.out.println (testing.addQueen (-3,2));
    System.out.println (testing.toString ());
  }
}
