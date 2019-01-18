public class driver{
  public static void main(String[]args){
    Hand h1 = new Hand();
    h1.add(new Card(3, 'S'));
    h1.add(new Card(4, 'S'));
    h1.add(new Card(5, 'S'));
    h1.add(new Card(6, 'S'));
    h1.add(new Card(7, 'S'));
    h1.sort();
    System.out.println(h1);
    System.out.println(h1.royalFlush());
  }
}
