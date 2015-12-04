package cs4800.classproject.Main;

import cs4800.classproject.TreeItems.Edge;
import cs4800.classproject.TreeItems.UndirectedGraph;

import java.util.ArrayList;

/**
 * To represent Kurskal's algorithm
 */
public final class Kruskal {
  /**
   * To create a MST from a given {@link UndirectedGraph}
   * @param graph the given {@link UndirectedGraph}
   * @return a MST in the from of a {@link UndirectedGraph}
   */
  public static UndirectedGraph run(UndirectedGraph graph) {
    UnionFind uf = new UnionFind();
    ArrayList<Edge> edges = new ArrayList<>();
    graph.getVertices().forEach(uf::create);
    graph.getEdges().stream().filter(e -> uf.find(e.getStart()) != uf.find(e.getEnd()))
        .forEach(e -> {
          edges.add(e);
          uf.union(e.getStart(), e.getEnd());
        });
    return new UndirectedGraph(graph.getVertices(), edges);
  }
}
