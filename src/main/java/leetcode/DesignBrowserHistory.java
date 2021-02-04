package leetcode;

import java.util.HashMap;

public class DesignBrowserHistory {

  HashMap<Integer, String> cache = new HashMap<>();
  int index = 0;

  public DesignBrowserHistory(String homepage) {
    cache.put(index, homepage);
  }

  public void visit(String url) {
    int iter = index;
    while (cache.containsKey(++iter)) {
      cache.remove(iter);
    }
    cache.put(++index, url);
  }

  public String back(int steps) {
    index = Math.max(index - steps, 0);
    return cache.get(index);
  }

  public String forward(int steps) {
    int target = index + steps;
    while (index < target && cache.containsKey(index)) ++index;
    return cache.getOrDefault(target, null);
  }

  public static void main(String[] args) {
    var history = new DesignBrowserHistory("leetcode.come");
    history.visit("google.com");
    history.visit("facebook.com");
    history.visit("youtube.com");
    var v1 = history.back(1);
    var v2 = history.back(1);
    var v3 = history.forward(1);
    history.visit("linkedin.com");
    var v4 = history.forward(2);
    var v5 = history.back(2);
    var v6 = history.back(7);
  }
}
