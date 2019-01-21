public class RouletteDriver {
  public static void main(String[] args) {
    Roulette test = new Roulette(new Player(1000));
    System.out.println(test.printBoard());
    test.run();
  }
}
