public class DriverSlots {
  public static void main(String[] args) {
    double net = 0;
    Player me = new Player(1000000);
    System.out.println(me.getBal());
    SlotsTriple test3 = new SlotsTriple();
    for (int i = 0; i < 10000; i++) {
      test3.spin(1000);
      test3.interpretSpin();
      net += test3.getPayout();
      me.changeBal(test3.getPayout());
    }
    System.out.println("You balance has been changed by: " + net);
    System.out.println("Your current balance is: $" + me.getBal());
  }
}
