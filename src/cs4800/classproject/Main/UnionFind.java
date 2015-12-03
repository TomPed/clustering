package cs4800.classproject.Main;

import cs4800.classproject.TreeItems.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * To represent a union find
 */
public final class UnionFind {
  private final HashMap<Vertex, ArrayList<Vertex>> childrenMap = new HashMap<>();
  private final HashMap<Vertex, Vertex> parentMap = new HashMap<>();

  /**
   * Used to create a childrenMap for the given {@link Vertex} and a parentMap
   * for the given {@link Vertex} in this {@link UnionFind}
   * @param v the given {@link Vertex}
   */
  public void create(Vertex v) {
    this.childrenMap().put(v, new ArrayList<>(Collections.singletonList(v)));
    this.parentMap().put(v, v);
  }

  /**
   * To find the parent of the given {@link Vertex} in this {@link UnionFind}
   * @param v the given {@link Vertex}
   * @return the parent of the given {@link Vertex} in this {@link UnionFind}
   */
  public Vertex find(Vertex v) {
    return this.parentMap().get(v);
  }

  /**
   * To union two given {@link Vertex}s in this {@link UnionFind}
   * @param a first given {@link Vertex}
   * @param b second given {@link Vertex}
   */
  public void union(Vertex a, Vertex b) {
    Vertex rentA = this.find(a);
    Vertex rentB = this.find(b);

    if (this.childrenMap().get(rentA).size() > this.childrenMap().get(this.find(b)).size()) {
      for (Vertex v : this.childrenMap().get(rentB)) {
        this.parentMap().put(v, rentA);
        this.childrenMap().get(rentA).add(v);
      }
      this.childrenMap().remove(rentB); // remove it
    } else {
      for (Vertex v : this.childrenMap().get(rentA)) {
        this.parentMap().put(v, rentB);
        this.childrenMap().get(rentB).add(v);
      }
      this.childrenMap().remove(rentA); // remove it
    }
  }

  /**
   * To get the parent to children map of this {@link UnionFind}
   * @return the parent to children map of this {@link UnionFind}
   */
  public HashMap<Vertex, ArrayList<Vertex>> childrenMap() {
    return this.childrenMap;
  }

  /**
   * To get the child to parent map of this {@link UnionFind}
   * @return the child to parent map of this {@link UnionFind}
   */
  public HashMap<Vertex, Vertex> parentMap() {
    return this.parentMap;
  }

  /**
   * To make the cluster in the form of a group of {@link Vertex}s
   * @return a cluster in the form of a group of {@link Vertex}s
   */
  public ArrayList<ArrayList<Vertex>> makeClusters() {
    HashMap<Vertex, ArrayList<Vertex>> map = new HashMap<>();
    ArrayList<ArrayList<Vertex>> cluster = new ArrayList<>();

    for (Vertex v : this.parentMap().keySet()) {
      Vertex rent = this.find(v);
      if (map.containsKey(rent)) {
        map.get(rent).add(v);
      } else {
        map.put(rent, new ArrayList<>(Collections.singletonList(v)));
      }
    }
    cluster.addAll(map.keySet().stream().map(map::get).collect(Collectors.toList()));
    return cluster;
  }
}
