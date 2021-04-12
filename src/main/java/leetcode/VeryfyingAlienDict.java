package leetcode;

public class VeryfyingAlienDict {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length < 2) return true;

        String latest = words[0];

        for(int i = 1; i < words.length; i++){
            String current = words[i];
            int k = 0;
            for(; k < Math.min(current.length(), latest.length()); k++){
                char lc = latest.charAt(k), cc = current.charAt(k);
                if(lc == cc) continue;
                int diff = order.indexOf(cc) - order.indexOf(lc);
                if(diff < 0) return false;
                else break;
            }
            if(k == Math.min(current.length(), latest.length()) && current.length() < latest.length()) return false;
            latest = current;
        }
        return true;
    }

  public static void main(String[] args) {
    var vad = new VeryfyingAlienDict();
    var b = vad.isAlienSorted(new String[]{"kuvp","q"}, "ngxlkthsjuoqcpavbfdermiywz");
  }
}
