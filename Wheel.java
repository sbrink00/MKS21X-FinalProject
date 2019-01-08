import java.util.*;
public class Wheel {
  private ArrayList<Tile> wheel;
  private Random r;
  public Wheel() {
    r= new Random();
    values = new int[]{0, 32, 15, 19, 4, 21, 2, 25, 17, 37, 6, 27,
              13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33,
              1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35,
              3, 26};
    for (int i = 0; i < 37; i++) {
      if (values[i] != 0) {
        if (values[i] % 2 == 0) odds[i] = false;
        else if (values[i] % 2 == 1) odds[i] = true;
      }
      else if (values[i] == 0) {
        colors[i] = 'G';
      }
      if (i != 0) {
        if (i % 2 == 0) {
          colors[i] = 'B';
        }
        else colors[i] = 'R';
      }
    }
  }
  public int spin() {
    return (Math.abs(r.nextInt()) % 37);
  }
}
