package Problems.problem57;

import java.math.BigInteger;

/**
 * 3/2, 7/5, 17/12, 41/29, 99/70, 239/169
 */

public class Problem57 {

  private BigInteger numerator = BigInteger.valueOf(3);
  private BigInteger denominator = BigInteger.valueOf(2);
  private BigInteger numTemp = BigInteger.ONE;
  private BigInteger denTemp = BigInteger.ONE;

  public int problem57Solution() {
    return getBruteForceSolution(1000);
  }

  private int getBruteForceSolution(int index) {
    int counter = 0;
    for (int i = 0; i < index; ++i) {
      if (getFractions()) {
        counter++;
      }
    }
    return counter;
  }

  private boolean getFractions() {
    BigInteger num = numerator;
    BigInteger den = denominator;
    numerator = numerator.add(numerator).add(numTemp);
    denominator = denominator.add(denominator).add(denTemp);
    numTemp = num;
    denTemp = den;
    return countDigits(numerator, denominator);
  }

  private boolean countDigits(BigInteger num1, BigInteger num2) {
  return num1.toString().length() > num2.toString().length();
  }
}
