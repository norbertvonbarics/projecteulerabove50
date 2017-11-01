package Problem51;

import Utils.Prime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the
 * nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003,
 * being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number
 * (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 */
public class Problem51 {

  Prime prime = new Prime();
  List<Integer> primes = getPrimes(10000);

  public boolean problem51Solution() {
    System.out.println(getPrimes(10));
    int num = 189402354;
    System.out.println(sortCharArray(num));
    return false;
  }

  private List<Integer> getPrimes(int size) {
    List<Integer> primes = new ArrayList<>();
    for (int i = 0; ; i++) {
      if (prime.isPrime(i)) {
        primes.add(i);
      }
      if (primes.size() > 9) {
        return primes;
      }
    }
  }

  private boolean checkDigits() {
    for (int i = 0; i < primes.size(); i++) {
      for (int j = 0; j < 8; j++) {
      }
    }
    return false;
  }

  private int sortCharArray(int num) {
    String text = Integer.toString(num);
    List<Character> sorted = new ArrayList<>();
    for (int i = 0; i < text.length(); i++) {
      sorted.add(text.charAt(i));
    }
    Collections.sort(sorted);
    StringBuilder returnText = new StringBuilder();
    for (Character aSorted : sorted) {
      returnText.append(aSorted);
    }
    return Integer.parseInt(returnText.toString());
  }
}
