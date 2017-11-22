package Problems;

import Utils.Utility;
import java.math.BigInteger;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general,
 *
 * nCr =   n! r!(n−r)! ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1. It is not until n = 23,
 * that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than
 * one-million?
 */

public class Problem52 {

  Utility utility = new Utility();

  public boolean problem52Solution() {
    return false;
  }

  private BigInteger getC(int n, int r) {
    BigInteger nFact = factorial(n);
    BigInteger rFact = factorial(r);
    BigInteger nMinusRFact = factorial(n - r);
    return nFact.divide((rFact.multiply(nMinusRFact)));
  }

  public BigInteger factorial(int number) {
    BigInteger fact = BigInteger.ONE;
    for (int i = number; i >= 1; --i) {
      fact = fact.multiply(BigInteger.valueOf(i));
    }
    return fact;
  }
}
