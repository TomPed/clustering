package cs4800.classproject.TreeItems;

import cs4800.classproject.Utilities.Utils;

import java.util.ArrayList;

/**
 * To represent an undirected tree
 */
public final class UndirectedGraph {
  private final ArrayList<Vertex> vertices;
  private final ArrayList<Edge> edges;

  /**
   * To construct an {@link UndirectedGraph}
   * @param vertices the given {@link Vertex}s
   */
  public UndirectedGraph(ArrayList<Vertex> vertices) {
    this.vertices = vertices;
    this.edges = Utils.makeEdges(this.vertices);
  }

  /**
   * To construct an {@link UndirectedGraph}
   * @param vertices the given {@link Vertex}s
   * @param edges the given {@link Edge}s
   */
  public UndirectedGraph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
    this.vertices = vertices;
    this.edges = edges;
  }

  /**
   * To get the {@link Vertex}s of this {@link UndirectedGraph}
   * @return the {@link Vertex}s of this {@link UndirectedGraph}
   */
  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }

  /**
   * To get the {@link Edge}s of this {@link UndirectedGraph}
   * @return the {@link Edge}s of this {@link UndirectedGraph}
   */
  public ArrayList<Edge> getEdges() {
    return this.edges;
  }
}
