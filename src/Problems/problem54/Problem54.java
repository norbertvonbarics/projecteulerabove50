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
    List<Integer> list1 = getIntegers(player1Cards);
    List<Integer> list2 = getIntegers(player2Cards);
    if (checkCards(player1Cards).equals(checkCards(player2Cards))) {
      int player1 = checkCards(player1Cards);
      if (player1 == 20) {
        int card1 = 0;
        int card2 = 0;
        for (int i = 0; i < list1.size(); i++) {
          for (int j = i+1; j < list1.size(); j++) {
            if (list1.get(i).equals(list1.get(j))) {
              card1 = list1.get(i);
            }
            if (list2.get(i).equals(list2.get(j))) {
              card2 = list2.get(i);
            }
          }
        }
        return card1 > card2;
      }
    }
    return checkCards(player1Cards) > checkCards(player2Cards);
  }

  private Integer checkCards(List<String> cards) {
    List<Integer> numbers = getIntegers(cards);
    String royalReference = "1011121314";
    StringBuilder cardsString = new StringBuilder();
    for (int num : numbers) {
      cardsString.append(num);
    }

    if (checkCardsSecondPart(cards) && isIStraight(numbers)) {
      if (cardsString.toString()
          .equals(royalReference)) {
        return 100;
      } else {
        return 90;
      }
    } else if (checkFullHouse(numbers).equals("poker")) {
      return 80;
    } else if (checkFullHouse(numbers).equals("fullhouse")) {
      return 70;
    } else if (checkCardsSecondPart(cards)) {
      return 60;
    } else if (isIStraight(numbers)) {
      return 50;
    } else if (checkFullHouse(numbers).equals("threeofakind")) {
      return 40;
    } else if (checkFullHouse(numbers).equals("twopairs")) {
      return 30;
    } else if (checkFullHouse(numbers).equals("pair")) {
      return 20;
    } else {
      return getHighCard(cards);
    }
  }

  private List<Integer> getIntegers(List<String> cards) {
    List<Integer> numbers = new ArrayList<>();
    cards.forEach(card -> numbers.add(checkCardsFirstPart(card)));
    Collections.sort(numbers);
    return numbers;
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
    if (occurence.stream().filter(num -> num.equals(4)).count() == 4) {
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
    return "maybehighcard";
  }

  private int getHighCard(List<String> cards) {
    List<Integer> numbers = getIntegers(cards);
    return numbers.get(numbers.size() - 1);
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
}
