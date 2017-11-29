package Problems.problem55;

import java.math.BigInteger;

public class Problem55 {

  public int problem55Solution() {
    return countLychrelNumberBelow10000();
  }


  private int countLychrelNumberBelow10000() {
    int counter = 0;
    for (int i = 10; i < 10001; i++) {
      if (isLychrel(i)) {
        counter++;
      }
    }
    return counter;
  }

  private boolean isLychrel(int number) {
    BigInteger tempNum = BigInteger.valueOf(number);
    for (int i = 0; i < 51; i++) {
      BigInteger reversedNum = reverseInteger(tempNum);
      tempNum = tempNum.add(reversedNum);
      if (tempNum.equals(reverseInteger(tempNum))) {
        return false;
      }
    }
    return true;
  }

  private BigInteger reverseInteger(BigInteger number) {
    return new BigInteger(new StringBuilder(number.toString()).reverse().toString());
  }
}
