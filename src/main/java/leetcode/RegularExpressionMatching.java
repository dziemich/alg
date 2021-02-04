package leetcode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(p.equals(".*")) return true;

        if(p.length() == 1){
            if(s.length() != 1) return false;
            if(p.equals(".")) return true;
            return s.charAt(0) == p.charAt(0);
        }

        char last = p.charAt(0);

        if(last != '.' && last != s.charAt(0)) return false;

        int idx = 1;

        for(int i = 1; i < p.length(); i++){
            if(idx >= s.length()) return false;
            char pc = p.charAt(i);

            if(pc == '.'){
                last = pc;
                idx++;
                continue;
            }
            char sc = s.charAt(idx);

            if(pc == '*'){
                if(last == '.') return true;

                while(last == sc){
                    ++idx;
                    if(idx >= s.length()) return false;
                    sc = s.charAt(idx);
                }
                --idx;
            }

            if(pc != sc) return false;

            last = sc;
            ++idx;
        }

        return idx >= s.length();
    }

  public static void main(String[] args) {
    var rem = new RegularExpressionMatching();

    rem.isMatch("dupa", "du.*");
  }
}
