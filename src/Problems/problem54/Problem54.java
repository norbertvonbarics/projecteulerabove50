package Problems.problem54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem54 {

  //todo check same hands
  
  IOService ioservice = new IOService();

  public int problem54Solution() {
    return iterateThroughText();
  }

  private int iterateThroughText() {
    int player1win = 0;
    List<String> rawfile = ioservice.readFile();
    for (String hand : rawfile) {
      if (checkHand(hand)) {
        player1win++;
      }
    }
    return player1win;
  }

  private boolean checkHand(String cards) {
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
    return checkCards(player1Cards) > checkCards(player2Cards);
  }

  private Integer checkCards(List<String> cards) {
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
        return 1000;
      } else {
        return 900;
      }
    } else if (checkFullHouse(numbers).equals("poker")) {
      return 800;
    } else if (checkFullHouse(numbers).equals("fullhouse")) {
      return 700;
    } else if (checkCardsSecondPart(cards)) {
      return 600;
    } else if (isIStraight(numbers)) {
      return 500;
    } else if (checkFullHouse(numbers).equals("threeofakind")) {
      return 400;
    } else if (checkFullHouse(numbers).equals("twopairs")) {
      return 300;
    } else if (checkFullHouse(numbers).equals("pair")) {
      return 200;
    } else {
      return getHighCard(cards);
    }
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
    } else if (card.startsWith("T")) {
      return 10;
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
        if (numbers.get(i).equals(numbers.get(j))) {
          counter++;
        }
      }
      occurence.add(counter);
    }
    if (occurence.stream().filter(num -> num.equals(4)).count() > 0) {
      return "poker";
    } else if (occurence.stream().filter(num -> num.equals(3)).count() == 3
        && occurence.stream().filter(num -> num.equals(2)).count() == 2) {
      return "fullhouse";
    } else if (occurence.stream().filter(num -> num.equals(3)).count() == 3) {
      return "threeofakind";
    } else if (occurence.stream().filter(num -> num.equals(2)).count() == 4) {
      return "twopairs";
    } else if (occurence.stream().filter(num -> num.equals(2)).count() == 2) {
      return "pair";
    }
    return "highcard";
  }

  private int getHighCard(List<String> cards) {
    List<Integer> numbers = new ArrayList<>();
    cards.forEach(card -> numbers.add(checkCardsFirstPart(card)));
    Collections.sort(numbers);
    return numbers.get(numbers.size() - 1);
  }
}
