package Problem51;

import Utils.Prime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


/**
 * We induced that for an eight prime value family we were looking for a 6-digit prime number with 3
 * repeated digits. You can’t have 2 or 4 repeating digits because at least one of the 8 versions
 * will be divisible by 3. There are only 68,906 6-digit prime numbers to consider, but with some
 * thought we could eliminate most of them. Here’s the process we used:
 *
 * 1. We need look at only those primes that have exactly 3 repeating digits.
 * 2. The last (least significant) digit can’t be the repeating digit, because replacing it would
 * allow composite numbers.
 * 3. Lastly, since we are checking for an eight prime value family, we need only those
 * primes that have their repeating digit 0, 1 or 2; this reduced the set to only 1,305 primes.
 */
public class Problem51 {

  private Prime prime = new Prime();

  public boolean problem51Solution() {
    System.out.println(getPrimes().size());
    return false;
  }

  private List<Integer> getPrimes() {
    List<Integer> primes = new ArrayList<>();
    for (int i = 100000; i < 1000000; i++) {
      System.out.println(i);
      if(checkDigits(i)){
        primes.add(i);
      }
    }
    return primes;
  }

  private boolean checkDigits(int number) {
    String numberAsString = Integer.toString(number);
    List<Character> chars = numberAsString.chars().mapToObj(e -> (char) e)
        .collect(Collectors.toList());
    if (numberAsString.chars().filter(num -> num == '2').count() == 3) {
      return false;
    }
    if (numberAsString.chars().filter(num -> num == '4').count() == 3) {
      return false;
    }
    Set<Character> charSet = new HashSet<>(chars);
    return charSet.size() == 4 && prime.isPrime(number);
  }
}
