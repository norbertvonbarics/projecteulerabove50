package Problems.problem57;

public class Problem57 {

  public double problem57Solution() {
    return getExpansions(2);
  }

  private double getExpansions(int endIndex) {
    double number = 0;
    double temp = 0.5;
    for (int i = 0; i < endIndex; i++) {
      number = 1 / (2 + temp);
      temp = number;
    }
    return 1 + number;
  }
}
