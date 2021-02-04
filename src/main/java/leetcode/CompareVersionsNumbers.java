package leetcode;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class CompareVersionsNumbers {


  public int compareVersion(String version1, String version2) {

    int idx1 = 0;
    int idx2 = 0;

    String v1s = version1 + ".";
    String v2s = version2 + ".";

    int v1 = 0;
    int v2 = 0;

    while(idx1 < v1s.length() || idx2 < v2s.length()){

      char c1 = v1s.charAt(idx1);
      char c2 = v2s.charAt(idx2);

      if(c1 == '.' && c2 == '.'){
        int compare = Integer.compare(v1, v2);
        if(compare != 0) return compare;
        v1 = 0;
        v2 = 0;
        idx1++;
        idx2++;
      }

      if(c1 != '.'){
        v1 *= 10;
        v1 += c1 - '0';
        idx1++;
      }

      if(c2 != '.'){
        v2 *= 10;
        v2 += c2 - '0';
        idx2++;
      }

      idx1 = Math.min(idx1, v1s.length()-1);
      idx2 = Math.min(idx2, v1s.length()-1);
    }

    SortedMap<String, Integer> map  = new TreeMap<>();

    return 0;
  }

  public static void main(String[] args) {
    var cvn = new CompareVersionsNumbers();

    cvn.compareVersion("1.0", "1.0.0");
  }
}
