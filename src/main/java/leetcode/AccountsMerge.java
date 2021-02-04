package leetcode;

import java.util.*;

public class AccountsMerge {
  class UnionFind {
    int[] parent;

    public UnionFind(int size) {
      parent = new int[size];
      for (int i = 0; i < size; i++) parent[i] = i;
    }

    public int find(int id) {
      while (id != parent[id]) {
        parent[id] = parent[parent[id]];
        id = parent[id];
      }
      return id;
    }

    public void union(int id1, int id2) {
      parent[find(id1)] = find(id2);
    }
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {

    var unionfind = new UnionFind(10001);

    var mailId = new HashMap<String, Integer>();
    var mailName = new HashMap<String, String>();

    int id = 0;

    for (var account : accounts) {
      String name = account.get(0);

      for (int i = 1; i < account.size(); i++) {
        String mail = account.get(i);
        mailName.put(mail, name);
        if (!mailId.containsKey(mail)) {
          mailId.put(mail, id++);
        }
        unionfind.union(mailId.get(account.get(1)), mailId.get(mail));
      }
    }

    var unified = new HashMap<Integer, List<String>>();

    for (var mail : mailName.keySet()) {

      int index = unionfind.find(mailId.get(mail));
      unified.computeIfAbsent(index, integer -> new ArrayList<>()).add(mail);
    }

    for (var emails : unified.values()) {

      emails.sort(String::compareToIgnoreCase);
      emails.add(0, mailName.get(emails.get(0)));
    }

    return new ArrayList<>(unified.values());
  }
}
