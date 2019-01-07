public class DriverSlots {
  public static void main(String[] args) {
    Player me = new Player(1000000);
    System.out.println(me.getBal());
    SlotsTriple test3 = new SlotsTriple();
    test3.spin(1000);
    test3.interpretSpin();
    me.changeBal(test3.getPayout());
    System.out.println("Your balance has been changed by: $" + test3.getPayout());
    System.out.println("Your current balance is: $" + me.getBal());
  }
}
