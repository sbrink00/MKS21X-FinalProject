//This is a driver that we will use to test individual
//parts of our project. It won't contain any actual code
//used in the final version.
public class driver{
  public static void main(String[]args){
    Blackjack b1 = new Blackjack();
    b1.run();
    Card test = new Card(3, 'H');
    System.out.println(test);
    test.setHidden(true);
    System.out.println(test);
  }
}
