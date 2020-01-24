package problem1.concurrentSolution;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents the synchronized concurrent hash map operation.
 */
public class ConcurrentHashMapOperation {

  private ConcurrentHashMap<Integer, Integer> map;

  /**
   * Constructor.
   *
   * @param map the concurrent hash map
   */
  public ConcurrentHashMapOperation(
      ConcurrentHashMap<Integer, Integer> map) {
    this.map = map;
  }

  /**
   * Getter.
   *
   * @return the concurrent hash map
   */
  public ConcurrentHashMap<Integer, Integer> getMap() {
    return map;
  }

  /**
   * The synchronized operation on the hash map.
   *
   * @param studDate  click date
   * @param studClick click times
   */
  public synchronized void changeMap(int studDate, int studClick) {
    if (map.containsKey(studDate)) {
      map.put(studDate, map.get(studDate) + studClick);
    } else {
      map.put(studDate, studClick);
    }
  }
}
