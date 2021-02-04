package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimilarStringGroups {
  public int numSimilarGroups(String[] strs) {

    List<List<String>> groups = new ArrayList<>();

    List<String> starter = new ArrayList<>();

    starter.add(strs[0]);
    groups.add(starter);

    for (int i = 1; i < strs.length; i++) {
      var addedNowhere = true;
      for (var group : new ArrayList<>(groups)) {
        for (var s : new ArrayList<>(group)) {
          if (isSimilar(s, strs[i])) {
            group.add(strs[i]);
            addedNowhere = false;
          }
        }
      }

      if (addedNowhere) {
        List<String> newGroup = new ArrayList<>();
        newGroup.add(strs[i]);
        groups.add(newGroup);
      }
    }

    var map = new HashMap<Integer, List<Integer>>();

    return groups.size();
  }

  private boolean isSimilar(String s1, String s2) {

    int counter = 0;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) counter++;
      if (counter > 2) return false;
    }
    return counter == 2 || counter == 0;
  }

  public static void main(String[] args) {
    var ssg = new SimilarStringGroups();

//    var size = ssg.numSimilarGroups(new String[] {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"});
     ssg.numSimilarGroups(new String[] {"adbc", "abcd", "acbd"});
  }
}
