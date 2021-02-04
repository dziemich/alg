package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UndergroundSystem {

  static class StationTime {
    public String station;
    public int time;

    public StationTime(String station, int time) {
      this.station = station;
      this.time = time;
    }
  }

  HashMap<Integer, StationTime> idToStation = new HashMap<>();
  HashMap<String, List<Integer>> stationTimes = new HashMap<>();

  public UndergroundSystem() {
    idToStation = new HashMap<>();
    stationTimes = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    idToStation.put(id, new StationTime(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    StationTime st = idToStation.get(id);
    idToStation.remove(id);
    String key = st.station + "|" + stationName;
    List<Integer> values = stationTimes.getOrDefault(key, new ArrayList<>());
    values.add(t - st.time);
    stationTimes.put(key, values);
  }

  public double getAverageTime(String startStation, String endStation) {
    String key = startStation + "|" + endStation;
    if (!stationTimes.containsKey(key)) return 0.0;
    List<Integer> list = stationTimes.get(key);

    int sum = list.stream().reduce(Integer::sum).orElse(0);
    return sum / list.size();
  }
}
