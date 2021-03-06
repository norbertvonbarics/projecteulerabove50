package Problems;

import Utils.Prime;
import Utils.Utility;
import java.util.ArrayList;
import java.util.List;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible
 * values: 13, 23, 43, 53, 73, and 83, are all prime. <p> By replacing the 3rd and 4th digits of
 * 56**3 with the same digit, this 5-digit number is the first example having seven primes among the
 * ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family, is the smallest prime with this
 * property. <p> Find the smallest prime which, by replacing part of the number (not necessarily
 * adjacent digits) with the same digit, is part of an eight prime value family.
 */


/**
 * We induced that for an eight prime value family we were looking for a 6-digit prime number with 3
 * repeated digits. You can’t have 2 or 4 repeating digits because at least one of the 8 versions
 * will be divisible by 3. There are only 68,906 6-digit prime numbers to consider, but with some
 * thought we could eliminate most of them. Here’s the process we used:
 *
 * 1. We need look at only those primes that have exactly 3 repeating digits. 2. The last (least
 * significant) digit can’t be the repeating digit, because replacing it would allow composite
 * numbers. 3. Lastly, since we are checking for an eight prime value family, we need only those
 * primes that have their repeating digit 0, 1 or 2; this reduced the set to only 1,305 primes.
 */
public class Problem51 {

  private Prime prime = new Prime();
  private Utility utility = new Utility();
  private List<Integer> primes = getPrimes();

  public String problem51Solution() {
    return checkListForLowestPrimeOfTheFamily();
  }


  private String checkListForLowestPrimeOfTheFamily() {
    for (int i = 0; i < primes.size() - 8; i++) {
      if (checkNextSeven(i)) {
        return Integer.toString(primes.get(i));
      }
    }
    return "Maybe next time!";
  }

  private boolean checkNextSeven(int index) {
    String num = Integer.toString(primes.get(index));
    int counter = 0;
    String characters = "123456789";
    for (int i = 0; i < characters.length(); i++) {
      char[] tempArray = num.toCharArray();
      tempArray[0] = characters.charAt(i);
      tempArray[2] = characters.charAt(i);
      tempArray[4] = characters.charAt(i);
      String tempNum = utility.charArrayToString(tempArray);
      if (prime.isPrime(Integer.parseInt(tempNum))) {
        counter++;
      }
    }
    return counter == 8;
  }

  private List<Integer> getPrimes() {
    List<Integer> primes = new ArrayList<>();
    for (int i = 100000; i < 1000000; i++) {
      if (checkDigits(i)) {
        primes.add(i);
      }
    }
    return primes;
  }

  private boolean checkDigits(int number) {
    String numberAsString = Integer.toString(number);
    boolean checkCharacters = numberAsString.charAt(0) == numberAsString.charAt(2)
        && numberAsString.charAt(2) == numberAsString.charAt(4);
    return prime.isPrime(number) && checkCharacters;
  }
}

