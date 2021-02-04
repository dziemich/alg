package leetcode;

import java.util.AbstractMap;
import java.util.Map;

public class IntegerToEnglishWord {

  Map<String, String> numbers =
      Map.ofEntries(
          new AbstractMap.SimpleEntry<>("1", "One"),
          new AbstractMap.SimpleEntry<>("2", "Two"),
          new AbstractMap.SimpleEntry<>("3", "Three"),
          new AbstractMap.SimpleEntry<>("4", "Four"),
          new AbstractMap.SimpleEntry<>("5", "Five"),
          new AbstractMap.SimpleEntry<>("6", "Six"),
          new AbstractMap.SimpleEntry<>("7", "Seven"),
          new AbstractMap.SimpleEntry<>("8", "Eight"),
          new AbstractMap.SimpleEntry<>("9", "Nine"),
          new AbstractMap.SimpleEntry<>("11", "Eleven"),
          new AbstractMap.SimpleEntry<>("12", "Twelve"),
          new AbstractMap.SimpleEntry<>("13", "Thirteen"),
          new AbstractMap.SimpleEntry<>("14", "Fourteen"),
          new AbstractMap.SimpleEntry<>("15", "Fifteen"),
          new AbstractMap.SimpleEntry<>("16", "Sixteen"),
          new AbstractMap.SimpleEntry<>("17", "Seventeen"),
          new AbstractMap.SimpleEntry<>("18", "Eighteen"),
          new AbstractMap.SimpleEntry<>("19", "Nineteen"));

  Map<String, String> decimals =
      Map.of(
          "1", "Ten",
          "2", "Twenty",
          "3", "Thirty",
          "4", "Forty",
          "5", "Fifty",
          "6", "Sixty",
          "7", "Seventy",
          "8", "Eighty",
          "9", "Ninety");

  Map<Integer, String> quantities =
      Map.of(
          1, "Thousand",
          2, "Million",
          3, "Billion");

  public String numberToWords(int num) {

    if (num == 0) return "Zero";

    String number = String.valueOf(num);

    StringBuilder result = new StringBuilder();

    result.append(analyze3(number.substring(Math.max(0, number.length() - 3))));

    int quantityCounter = 0;
    for (int i = number.length() - 3; i > 0; i -= 3) {

      String analyzed = number.substring(Math.max(0, i - 3), i);
      quantityCounter++;
      if (!analyzed.equals("000")) {
        result.insert(0, " " + quantities.get(quantityCounter) + " ");
        result.insert(0, " " + analyze3(analyzed));
      }
    }
    return result.toString().replaceAll("\\s+", " ");
  }

  private String analyze3(String digits) {

    if (digits.isEmpty()) return "";
    if (digits.length() < 3) {
      if (digits.length() == 2) digits = "0" + digits;
      if (digits.length() == 1) digits = "00" + digits;
    }

    String firstDigit = digits.substring(0, 1);
    String hundreds = numbers.getOrDefault(firstDigit, "");
    String secondDigit = digits.substring(1, 2);
    String decims = decimals.getOrDefault(secondDigit, "");
    String thirdDigit = digits.substring(2);
    String last = numbers.getOrDefault(thirdDigit, "");

    if (secondDigit.equals("1")) {
      if (!thirdDigit.equals("0")) {
        decims = numbers.get(digits.substring(1));
        last = "";
      }
    }

    if (numbers.containsKey(firstDigit)) {
      hundreds = hundreds + " Hundred";
    }

    StringBuilder builder = new StringBuilder();

    if (!hundreds.isEmpty()) {
      builder.append(hundreds).append(" ");
    }

    if (!decims.isEmpty()) {
      builder.append(decims).append(" ");
    }

    if (!last.isEmpty()) {
      builder.append(last);
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    var itew = new IntegerToEnglishWord();
    System.out.println(itew.numberToWords(1));
  }
}
