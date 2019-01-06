//This is a driver that we will use to test individual
//parts of our project. It won't contain any actual code
//used in the final version.
public class driver{
  public static void main(String[]args){
    Shoe s1 = new Shoe(6);
    //System.out.println(s1);
    Hand h1 = new Hand();
    h1.add(new Card(3, 'C'));
    System.out.println(h1);
  }
}
