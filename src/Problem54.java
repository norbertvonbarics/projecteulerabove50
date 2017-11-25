import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem54 {

  public boolean problem54Solution() {
    List<String> cards = new ArrayList<>(Arrays.asList("5H", "6H", "7S", "8S", "9D"));
    List<String> cards2 = new ArrayList<>(Arrays.asList("5D", "6D", "7D", "8D", "9D"));
    List<String> cards3 = new ArrayList<>(Arrays.asList("10D", "JD", "QD", "KD", "AD"));

    System.out.println(checkCards(cards));
    System.out.println(checkCards(cards2));
    System.out.println(checkCards(cards3));
    return false;
  }

  private int checkHand(String cards) {
    String[] hands = cards.split(" ");
    List<String> player1Cards = new ArrayList<>();
    List<String> player2Cards = new ArrayList<>();
    for (int i = 0; i < hands.length; i++) {
      if (i < 5) {
        player1Cards.add(hands[i]);
      } else {
        player2Cards.add(hands[i]);
      }
    }
    return 1;
  }

  private int getWinnerOfTheRow(List<String> hand1, List<String> hand2) {
    Map<String, Integer> rankedHands = new HashMap<>();
    rankedHands.put("highcard", 1);
    rankedHands.put("onepair", 2);
    rankedHands.put("twopairs", 3);
    rankedHands.put("threeofakind", 4);
    rankedHands.put("straight", 5);
    rankedHands.put("flush", 6);
    rankedHands.put("fullhouse", 7);
    rankedHands.put("fourofakind", 8);
    rankedHands.put("straightflush", 9);
    rankedHands.put("royalflush", 10);

    return 1;
  }

  private String checkCards(List<String> cards) {
    List<Integer> numbers = new ArrayList<>();
    cards.forEach(card -> numbers.add(checkCardsFirstPart(card)));
    Collections.sort(numbers);
    String royalReference = "1011121314";
    StringBuilder cardsString = new StringBuilder();
    for (int num : numbers) {
      cardsString.append(num);
    }

    if (checkCardsSecondPart(cards) && isIStraight(numbers)) {
      if (cardsString.toString()
          .equals(royalReference)) {
        return "royalflush";
      } else {
        return "straightflush";
      }
    } else if (isIStraight(numbers)) {
      return "straight";
    } else if () {
//Todo below straight logic!!!!
    }

    return "next time";
  }


  private boolean isIStraight(List<Integer> numbers) {
    int counter = 0;
    for (int i = 0; i < numbers.size() - 1; i++) {
      if (numbers.get(i) == (numbers.get(i + 1) - 1)) {
        counter++;
      }
    }
    return counter == 4;
  }

  private int checkCardsFirstPart(String card) {
    if (card.startsWith("J")) {
      return 11;
    } else if (card.startsWith("Q")) {
      return 12;
    } else if (card.startsWith("K")) {
      return 13;
    } else if (card.startsWith("A")) {
      return 14;
    } else if (card.length() == 3) {
      return Integer.parseInt(card.substring(0, 2));
    } else {
      return Integer.parseInt(card.substring(0, 1));
    }
  }

  private boolean checkCardsSecondPart(List<String> cards) {
    int counter = 0;
    for (int i = 1; i < cards.size(); i++) {
      int index = cards.get(0).length();
      int index2 = cards.get(i).length();
      String one = cards.get(0).substring(index - 1, index);
      String two = cards.get(i).substring(index2 - 1, index2);
      if (one.equals(two)) {
        counter++;
      } else {
        return false;
      }
    }
    return counter == 4;
  }

  private String checkFullHouse(List<Integer> numbers) {
    List<Integer> occurence = new ArrayList<>();
    for (int i = 0; i < numbers.size(); i++) {
      int counter = 0;
      for (int j = 0; j < numbers.size(); j++) {
        if(Objects.equals(numbers.get(i), numbers.get(j))) {counter++;}
      }
    }

    if(occurence.stream().filter(num -> num.equals(4)).count() >0) {
      return "poker";
    } else if (occurence.stream().filter(num -> num.equals(3)).count() == 1
        && occurence.stream().filter(num -> num.equals(2)).count() == 2) {
      return "fullofahouse";
    } else if(occurence.stream().filter(num -> num.equals(3)).count() == 1) {
      return "threeofakind";
    } else if (occurence.stream().filter(num -> num.equals(2)).count() == 4) {
      return "twopairs";
    } else if (occurence.stream().filter(num -> num.equals(2)).count() == 2) {
      return "pair";
    }
    return "highcard";
  }
}
