public class RouletteDriver {
  public static void main(String[] args) {
    Roulette test = new Roulette();
    System.out.println(test.printBoard());
    Tile output = test.spin();
    System.out.println(output.toString());
  }
}
