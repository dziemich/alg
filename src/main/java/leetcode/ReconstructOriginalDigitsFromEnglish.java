package leetcode;

public class ReconstructOriginalDigitsFromEnglish {
  /*
   one seven nine

  zero one two three four five six seven eight nine

  one z -> 0
  one x -> 6
  one u -> 4
  one w -> 2
  one g -> 8
  one f -> 5
  one h -> 3
  one v -> 7
  one i -> 9
  rest -> 1
   */

  public String originalDigits(String s) {

    int[] chars = new int[26];
    StringBuilder res = new StringBuilder();

    for (char c : s.toCharArray()) {
      chars[c - 'a']++;
    }

    // handle zero
    int counter = chars['z' - 'a'];

    chars['z' - 'a'] -= counter;
    chars['e' - 'a'] -= counter;
    chars['r' - 'a'] -= counter;
    chars['o' - 'a'] -= counter;

    res.append("0".repeat(Math.max(0, counter)));

    // handle two

    counter = chars['w' - 'a'];
    chars['t' - 'a'] -= counter;
    chars['w' - 'a'] -= counter;
    chars['o' - 'a'] -= counter;
    res.append("2".repeat(Math.max(0, counter)));

    // handle four

    counter = chars['u' - 'a'];
    chars['f' - 'a'] -= counter;
    chars['o' - 'a'] -= counter;
    chars['u' - 'a'] -= counter;
    chars['r' - 'a'] -= counter;
    res.append("4".repeat(Math.max(0, counter)));

    // handle four

    counter = chars['f' - 'a'];
    chars['f' - 'a'] -= counter;
    chars['i' - 'a'] -= counter;
    chars['v' - 'a'] -= counter;
    chars['e' - 'a'] -= counter;
    res.append("5".repeat(Math.max(0, counter)));

    // handle six
    counter = chars['x' - 'a'];

    chars['s' - 'a'] -= counter;
    chars['i' - 'a'] -= counter;
    chars['x' - 'a'] -= counter;

    res.append("6".repeat(Math.max(0, counter)));

    // handle seven
    counter = chars['v' - 'a'];

    chars['s' - 'a'] -= counter;
    chars['e' - 'a'] -= counter * 2;
    chars['v' - 'a'] -= counter;
    chars['n' - 'a'] -= counter;

    res.append("7".repeat(Math.max(0, counter)));

    // handle eight
    counter = chars['g' - 'a'];

    chars['e' - 'a'] -= counter;
    chars['i' - 'a'] -= counter;
    chars['g' - 'a'] -= counter;
    chars['h' - 'a'] -= counter;
    chars['t' - 'a'] -= counter;

    res.append("8".repeat(Math.max(0, counter)));

    // handle nine
    counter = chars['i' - 'a'];

    chars['n' - 'a'] -= counter * 2;
    chars['i' - 'a'] -= counter;
    chars['e' - 'a'] -= counter;

    res.append("9".repeat(Math.max(0, counter)));

    // handle one
    counter = chars['o' - 'a'];

    chars['o' - 'a'] -= counter * 2;
    chars['n' - 'a'] -= counter;
    chars['e' - 'a'] -= counter;

    int prev = res.lastIndexOf("0");

    res.insert(prev == -1 ? 0 : prev + 1, "1".repeat(Math.max(0, counter)));

    // handle three
    prev = Math.max(res.lastIndexOf("0"), Math.max(res.lastIndexOf("1"), res.lastIndexOf("2")));

    counter = chars['t' - 'a'];
    res.insert(prev == -1 ? 0 : prev + 1, "3".repeat(Math.max(0, counter)));

    return res.toString();
  }

  public static void main(String[] args) {
    var rodfe = new ReconstructOriginalDigitsFromEnglish();

    rodfe.originalDigits("neoorez");
  }
}
