package leetcode;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments {
  public List<String> removeComments(String[] source) {
    boolean block = false;
    List<String> output = new LinkedList<>();
    for (String s : source) {

      int openBlockIndex = s.indexOf("/*");

      if (openBlockIndex != -1) {
        block = !s.contains("*/");
        output.add(s.substring(0, openBlockIndex));
        continue;
      }

      int closeBlockIndex = s.indexOf("*/");

      if (closeBlockIndex != -1) {
        block = false;
        output.add(s.substring(closeBlockIndex));
        continue;
      }

      int lineIndex = s.indexOf("//");

      if (lineIndex != -1) {
        output.add(s.substring(0, lineIndex));
        continue;
      }

      if (block) continue;
      output.add(s);
    }

    return output;
  }

  public static void main(String[] args) {
    var rc = new RemoveComments();

    List<String> output =
        rc.removeComments(
            new String[] {
              "/*Test program */",
              "int main()",
              "{ ",
              "  // variable declaration ",
              "int a, b, c;",
              "/* This is a test",
              "   multiline  ",
              "   comment for ",
              "   testing */",
              "a = b + c;",
              "}"
            });

    System.out.println("DONE");
  }
}
