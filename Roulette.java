public class Roulette {
  private Random r;
  private Wheel wheel;
  public Roulette() {
    wheel = new Wheel();
    r = new Random();
  }
  public int spin() {
    return (Math.abs(r.nextInt()) % 37);
  }
}
