package leetcode;

public class AlienDictionary {
  public String alienOrder(String[] words) {

    StringBuilder dictionary = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {

        String w1 = words[i];
        String w2 = words[j];

        for (int k = 0; k < Math.min(w1.length(), w2.length()); k++) {
          char c1 = w1.charAt(k);
          char c2 = w2.charAt(k);

          if (dictionary.indexOf(String.valueOf(c1)) != -1
              && dictionary.indexOf(String.valueOf(c2)) != -1) continue;

          if (c1 != c2) {
            int index = dictionary.indexOf(String.valueOf(c1));
            if (index == -1) {
              dictionary.insert(0, c1);
              dictionary.insert(1, c2);
            } else {
              dictionary.insert(index + 1, c2);
            }
          }
        }
      }
    }
    return dictionary.toString();
  }
}
