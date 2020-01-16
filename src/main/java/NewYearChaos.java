public class NewYearChaos {

  static void minimumBribes(int[] q) {
    int counter = 0;
    for (int i = 0; i < q.length; i++) {
      int num = q[i];
      if (num - i > 3) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Math.max(0, q[i] - 2); j<i; j++){
        if (q[j] > num){
          counter++;
        }
      }
    }
    System.out.println(counter);
  }

  public static void main(String[] args) {
    int[] x = {1, 2, 5, 3, 7, 8, 6, 4};
    NewYearChaos.minimumBribes(x);
  }
}

/*
12345678 S
12354678 4-5
12534678 3-5
12534768 6-7
12537468 4-7
12537648 4-6
12537684 4-8
12537864 6-8
 */
