package Utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utility {

  public List<Character> getStringAsCharList(String text) {
    return text.chars().mapToObj(e -> (char) e)
        .collect(Collectors.toList());
  }

  public String charListToString(List<Character> chars) {
    StringBuilder text = new StringBuilder();
    for (char c : chars) {
      text.append(c);
    }
    return text.toString();
  }

  public String charArrayToString(char[] array) {
    StringBuilder temp = new StringBuilder();
    for (char c : array) {
      temp.append(c);
    }
    return temp.toString();
  }

  public int characterOccurence(String text, char c) {
    return (int) text.chars().filter(num -> num == c).count();
  }
}
