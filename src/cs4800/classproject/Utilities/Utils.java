package cs4800.classproject.Utilities;

import cs4800.classproject.Main.UnionFind;
import cs4800.classproject.TreeItems.Edge;
import cs4800.classproject.TreeItems.UndirectedGraph;
import cs4800.classproject.TreeItems.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * To represent a utility class
 */
public final class Utils {
  /**
   * To calculate the euclidean distance between two {@link Vertex}s
   * @param a the first {@link Vertex}
   * @param b the second {@link Vertex}
   * @return the euclidean distance between two {@link Vertex}s
   * @throws IllegalStateException if {@link Vertex}s are malformed
   */
  public static double distance(Vertex a, Vertex b) throws IllegalStateException {
    double sum = 0;
    if (a.getData().size() != b.getData().size()) {
      throw new IllegalArgumentException("Vertices must have same data length.");
    }
    for (int i = 0; i < a.getData().size(); i++) {
      sum+=Math.pow((a.getData().get(i) - b.getData().get(i)), 2);
    }
    return Math.sqrt(sum);
  }

  /**
   * To create a sorted list of {@link Edge}s
   * @param vertices the given {@link Vertex}s
   * @return a sorted list of {@link Edge}s
   */
  public static ArrayList<Edge> makeEdges(ArrayList<Vertex> vertices) {
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < vertices.size(); i++) {
      for (int j = i + 1; j < vertices.size(); j++) {
        edges.add(new Edge(Utils.distance(vertices.get(i), vertices.get(j)),
            vertices.get(i), vertices.get(j)));
      }
    }
    Collections.sort(edges); //sorting
    return edges;
  }

  /**
   * Processes a given file for future use
   *
   * @param fileName the name of given file
   * @return a {@link ArrayList} containing the line data
   */
  public static ArrayList<Vertex> parse(String fileName) {
    ArrayList<Vertex> result = new ArrayList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String currLine;
      int lineCount = 0;
      while ((currLine = reader.readLine()) != null) {
        if (lineCount >= 96) {
          ArrayList<Double> r = new ArrayList<>();
          String[] thisLineData = currLine.split(",");
          for (int i = 0; i < 19; i++) {
            r.add(Double.parseDouble(thisLineData[i]));
          }
          result.add(new Vertex(Classes.toEnum(thisLineData[19]), r));
        }
        lineCount++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Used to create a forest of trees from the given {@link UndirectedGraph}
   * and {@code k}
   * @param graph the given {@link UndirectedGraph}
   * @param k the given number of clusters
   * @return a forest of trees from the given {@link UndirectedGraph} and {@code k}
   *         in the form of an {@link ArrayList}
   * @throws IllegalArgumentException if k > number of edges in the given
   *                                  {@link UndirectedGraph}
   */
  public static ArrayList<ArrayList<Vertex>> kMeansCluster(UndirectedGraph graph, int k) {
    ArrayList<Edge> edges = new ArrayList<>(graph.getEdges());
    UnionFind uf = new UnionFind();

    for (int i = 0; i < k - 1; i++) {
     edges.remove(Collections.max(edges));
    }
    graph.getVertices().forEach(uf::create);
    for (Edge e : edges) {
      uf.union(e.getStart(), e.getEnd());
    }
    return uf.makeClusters();
  }

  /**
   * To calculate the purity of the clusters from the given group of {@link Vertex}s
   * @param clusters the given group of {@link Vertex}s
   * @return the purity of the clusters from the given group of {@link Vertex}s
   */
  public static double purity(ArrayList<ArrayList<Vertex>> clusters) {
    int vertexCount = 0;
    int majoritySumCount = 0;

    for (ArrayList<Vertex> cluster : clusters) {
      vertexCount += cluster.size();
      majoritySumCount += majorityType(cluster);
    }
    return (1.0 / vertexCount) * (majoritySumCount);
  }

  /**
   * To calculate the majority {@link Classes} from the given {@link Vertex}s
   * @param vertices the given {@link Vertex}s
   * @return the number of the majority {@link Classes} from the given {@link Vertex}s
   */
  public static int majorityType(ArrayList<Vertex> vertices) {
    HashMap<Classes, Integer> majorityTypeCount = new HashMap<>();

    for (Vertex v : vertices) {
      if (majorityTypeCount.containsKey(v.getType())) {
        int count = majorityTypeCount.get(v.getType());
        majorityTypeCount.put(v.getType(), count + 1);
      } else {
        majorityTypeCount.put(v.getType(), 1);
      }
    }
    return Collections.max(majorityTypeCount.values());
  }
}
