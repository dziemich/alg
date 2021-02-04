package leetcode;

import java.util.*;

public class ReconstructItinerary {

  HashMap<String, List<String>> flights = new HashMap<>();

  List<String> res = new ArrayList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> ticket : tickets) {
      var destinations = flights.getOrDefault(ticket.get(0), new ArrayList<>());
      destinations.add(ticket.get(1));
      flights.put(ticket.get(0), destinations);
    }

    ArrayList<String> start = new ArrayList<>();
    start.add("JFK");
    dfs("JFK", start, tickets.size());
    return res;
  }

  void dfs(String airport, List<String> itinerary, int ticketCount) {
    if (itinerary.size() == ticketCount) {
      if (res.isEmpty()) {
        res = itinerary;
      } else {
        res = lexMin(res, itinerary);
      }
    }

    for (String s : flights.getOrDefault(airport, new ArrayList<>())) {
      ArrayList<String> copy = new ArrayList<>(itinerary);
      copy.add(s);
      dfs(s, copy, ticketCount);
    }
  }

  private List<String> lexMin(List<String> res, List<String> itinerary) {
    for (int i = 1; i < itinerary.size(); i++) {
      String resAirport = res.get(i);
      String itAirport = res.get(i);

      for (int j = 0; j < 3; j++) {
        int diff = Integer.compare((int) resAirport.charAt(j), (int) itAirport.charAt(j));
        if (diff == 1) return res;
        else if (diff == -1) return itinerary;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    var ri = new ReconstructItinerary();

    ri.findItinerary(
        List.of(
            List.of("MUC", "LHR"),
            List.of("JFK", "MUC"),
            List.of("SFO", "SJC"),
            List.of("LHR", "SFO")));
  }
}
