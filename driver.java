public class driver{
  public static void main(String[]args){
    Hand h1 = new Hand();
    h1.add(new Card(3, 'S'));
    h1.add(new Card(6, 'S'));
    h1.add(new Card(8, 'S'));
    h1.add(new Card(8, 'S'));
    h1.add(new Card(8, 'S'));
    h1.sort();
    System.out.println(h1.subHand(5, 69));
    //System.out.println(h1.flush());
  }
}
