//This is a driver that we will use to test individual
//parts of our project. It won't contain any actual code
//used in the final version.
public class driver{
  public static void main(String[]args){
    //Card a = new Card(7, 'C');
    //System.out.println(a.getValue());
    Deck d1 = new Deck();
    //System.out.println(d1);
    Shoe s1 = new Shoe(1);
    System.out.println(s1);
  }
}
