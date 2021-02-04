package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveSubfoldersFromFilesystem {
  public List<String> removeSubfolders(String[] folder) {
    HashSet<String> seen = new HashSet<>();

    Arrays.sort(folder);

    for (String f : folder) {
      int index = f.lastIndexOf("/");
      if (index == 0) {
        seen.add(f);
        continue;
      }


      

      while (index != -1) {
        String parent = f.substring(0, index);
        if (!seen.contains(parent)) {
          seen.add(f);
          break;
        }
        index = parent.lastIndexOf("/");
      }
    }

    return new ArrayList<>(seen);
  }

  public static void main(String[] args) {
    var rsff = new RemoveSubfoldersFromFilesystem();

    List<String> strings =
        rsff.removeSubfolders(new String[] {"/a", "/c", "/a/b", "/c/d", "/c/d/e", "/c/f"});
    System.out.println("DONE");
  }
}
