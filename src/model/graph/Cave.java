package model.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Direction;
import model.Treasure;
import model.TreasureHolder;

public class Cave implements TreasureHolder, Location {
  
  private Set<Direction> directions;
  private Map<Treasure, Integer> treasures;
  
  public Cave() {
    this.directions = new HashSet<>();
    this.treasures = new HashMap<>();
  }
  
  public Cave(Set<Direction> newDirections,
      Map<Treasure, Integer> newTreasures) {
    this.directions = new HashSet<>();
    this.treasures = new HashMap<>();
    this.directions.addAll(newDirections);
    this.treasures.putAll(newTreasures);
  }

  @Override
  public boolean canWalk(Direction d) {
    return this.directions.contains(d);
  }

  @Override
  public void setDirectsSet(Set<Direction> newDirections) {
    this.directions = new HashSet<>();
    this.directions.addAll(newDirections);
  }

  @Override
  public void addNewDirection(Direction d) {
    this.directions.add(d);
  }

  @Override
  public void removeDirection(Direction d) {
    this.directions.remove(d);
  }

  @Override
  public void clearAllDirections() {
    this.directions.clear();
  }

  @Override
  public void setTreasureMap(Map<Treasure, Integer> newTreasures) {
    this.treasures = new HashMap<>();
    this.treasures.putAll(newTreasures);
  }

  @Override
  public Map<Treasure, Integer> getTreasures() {
    Map<Treasure, Integer> resMap = new HashMap<>();
    resMap.putAll(this.treasures);
    return resMap;
  }

  @Override
  public int getTreasureCount(Treasure treasureName) {
    if (this.treasures.containsKey(treasureName)) {
      return this.treasures.get(treasureName);
    }
    return 0;
  }

  @Override
  public int getTotalTreasure() {
    int count = 0;
    for (int tmp : this.treasures.values()) {
      count += tmp;
    }
    return count;
  }

  @Override
  public boolean canHoldTreasureNow() {
    return true;
  }

}