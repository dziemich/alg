package leetcode;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {



        if(k == 0){
            return new int[code.length];
        }

        int[] result = new int[code.length];

        if(k > 0){
            var sum = 0;
            for(int i = 1; i <= k; i++){
                sum += code[i];
            }
            result[0] = sum;
            for(int i = 1; i < code.length; i++){
                int prev = code[i];
                int next = (i + k) % code.length;
                sum = sum - prev + code[next];
                result[i] = sum;
            }
        }
        else {
            var sum = 0;
            for(int i = code.length - 2; i >= code.length + k - 1; i--){
                sum += code[i];
            }
            result[code.length - 1] = sum;
            for(int i = code.length - 2; i >= 0; i--){
                int prev = code[i];
                int next = i + k;
                if(next < 0){
                    next = code.length + next;
                }
                sum = sum - prev + code[next];
                result[i] = sum;
            }
        }

        return result;

    }

  public static void main(String[] args) {
    var dtb = new DefuseTheBomb();

    dtb.decrypt(new int[]{2,4,9,3}, -2);

  }
}
