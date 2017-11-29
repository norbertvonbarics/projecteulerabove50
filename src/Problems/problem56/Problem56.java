package Problems.problem56;

import java.math.BigInteger;
import java.util.stream.Stream;
import javax.naming.ldap.ManageReferralControl;

public class Problem56 {

  public long problem56Solution() {
    return findTheHighestSum();
  }

  private int digitSum(String num) {
    return Stream.of(num.split(""))
        .mapToInt(Integer::valueOf).sum();
  }

  private long findTheHighestSum() {
    int maxPower = 0;
    for (int i = 1; i < 101; i++) {
      for (int j = 1; j < 101; j++) {
        String asString = power(i,j);
        if (digitSum(asString) > maxPower) {
          maxPower = digitSum(asString);
        }
      }
    }
    return (long) maxPower;
  }

  private String power(int a, int b) {
    BigInteger power = BigInteger.ONE;
    BigInteger num = BigInteger.valueOf(a);
    for (int i = 0; i < b; i++) {
      power = power.multiply(num);
    }
    return power.toString();
  }
}
