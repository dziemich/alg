package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

  HashMap<Integer, Integer> map = new HashMap<>();
  ArrayList<Integer> list = new ArrayList<>();

  public InsertDeleteGetRandomO1() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (map.containsKey(val)) return true;
    map.put(val, list.size());
    list.add(val);
    return false;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (map.containsKey(val)) {
      if(list.size() == 1) {
        list.remove(0);
        map.remove(val);
        return true;
      }

      int idx = map.get(val);
      int swapped = list.get(list.size() - 1);

      list.set(idx, swapped);
      list.remove(list.size() - 1);

      map.remove(val);
      map.put(swapped, idx);
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int i = new Random().nextInt(list.size());
    new ArrayList<>(new HashSet<>());
    return list.get(i);
  }
}
