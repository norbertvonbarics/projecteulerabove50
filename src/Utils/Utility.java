package Utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by The allmighty
 * ____________________  ____   _____  _________________________
 * \______   \______   \/_   | /     \ \_____  \______   \   _  \
 * |     ___/|       _/ |   |/  \ /  \  _(__  <|       _/  /_\  \
 * |    |    |    |   \ |   /    Y    \/       \    |   \  \_/   \
 * |____|    |____|_  / |___\____|__  /______  /____|_  /\_____  /
 *                  \/              \/       \/       \/       \/
 * on 2017. 11. 15..
 */
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
    for (char c: array) {
      temp.append(c);
    }
    return temp.toString();
  }

  public int characterOccurence(String text, char c) {
    return (int) text.chars().filter(num -> num == c).count();
  }
}
