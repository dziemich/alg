package leetcode;

public class AreSentencesSimilar {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    String[] sen1 = sentence1.split(" ");
    String[] sen2 = sentence2.split(" ");

    int l1 = 0, l2 = 0;
    int r1 = sen1.length - 1;
    int r2 = sen2.length - 1;

    while (l1 <= r1 && l2 <= r2) {
      if (sen1[l1].equals(sen2[l2])) {
        l1++;
        l2++;
        continue;
      }
      if (sen1[r1].equals(sen2[r2])) {
        r1--;
        r2--;
        continue;
      }
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    String s1 = "My name is Haley";
    String s2 = "My name";

    var ass = new AreSentencesSimilar();

    boolean b = ass.areSentencesSimilar(s1, s2);
    System.out.println(b);
  }
}
