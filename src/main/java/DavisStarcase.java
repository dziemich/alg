import java.util.function.Function;

public class DavisStarcase {
  // Complete the stepPerms function below.
  static int stepPerms1(int n) {
    return makeAStep(0, 0, n);
  }

  static int makeAStep(int level, int counter, int max) {
    //    int levelCounter = counter;
    if (level == max) {
      return 1;
    }
    if (level == max - 1) {
      counter += makeAStep(level + 1, 0, max);
    } else if (level == max - 2) {
      counter += makeAStep(level + 1, 0, max);
      counter += makeAStep(level + 2, 0, max);
    } else {
      counter += makeAStep(level + 1, 0, max);
      counter += makeAStep(level + 2, 0, max);
      counter += makeAStep(level + 3, 0, max);
    }
    return counter;
  }

  static int stepPerms(int n) {
    int[] last3 = new int[] {1, 2, 4};
    if (n < 4) {
      return last3[n - 1];
    }
    for (int i = 4; i < n; i++) {
      last3[i - 1 % 3] = last3[0] + last3[1] + last3[2];
      last3[i - 1 % 3] = (int) (last3[i - 1 % 3] % 10000000007L);
    }
    return last3[0] + last3[1] + last3[2];
  }

  static Function<String, String> urlify =
      str -> str.replaceAll("(^ +)|( +$)", "").replaceAll("[ ]{2,}", "%20");

  public static void main(String[] args) {
    String expected = urlify.apply("    Mr     John     Smith     ");
    System.out.println(expected.equals("Mr%20John%20Smith") ? "PASSED" : "FAILED");
  }
}
