package leetcode;

import java.util.LinkedHashMap;

class LRUCache {
  LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
  int cap;

  public LRUCache(int capacity) {
    cache = new LinkedHashMap<>();
    this.cap = capacity;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) return -1;
    int val = cache.get(key);
    cache.remove(key);
    cache.put(key, val);
    return val;
  }

  public void put(int key, int value) {
    if(cache.containsKey(key)){
      int val = cache.get(key);
      cache.remove(key);
      cache.put(key, value);
      return;
    }
    if (cache.size() >= this.cap) {
      int last = cache.keySet().iterator().next();
      cache.remove(last);
    }
    cache.put(key, value);
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);
    cache.put(3, 3);
    cache.get(2);
    cache.put(4, 4);
    cache.get(1);
    cache.get(3);
    cache.get(4);
  }
  /*
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
  [       [2],  [1,1],[2,2], [1], [3,3], [2], [4,4], [1],  [3],  [4]]
     */
}
