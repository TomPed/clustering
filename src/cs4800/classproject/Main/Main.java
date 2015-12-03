package cs4800.classproject.Main;

import cs4800.classproject.TreeItems.UndirectedGraph;
import cs4800.classproject.TreeItems.Vertex;
import cs4800.classproject.Utilities.Utils;

import java.util.ArrayList;

/**
 * Main method for fall 2015 CS 4800 course project
 */
public final class Main {
  /**
   * To launch the program based on the given {@code args}
   * @param args given arguments
   */
  public static void main(String[] args) {
    long start = System.currentTimeMillis(); // start time of program
    UndirectedGraph graph = new UndirectedGraph(Utils.parse(args[0]));
    UndirectedGraph MST = Kruskal.run(graph);
    ArrayList<ArrayList<Vertex>> clusters = Utils.kMeansCluster(MST, Integer.parseInt(args[1]));
    long end = System.currentTimeMillis(); // end time of program
    System.out.println("Number of clusters: " + clusters.size());
    for (ArrayList<Vertex> cluster: clusters) System.out.println("Cluster: " + cluster);
    System.out.println("The purity is: " + Utils.purity(clusters));
    System.out.println("Seconds to calculate values: " + (end - start) * .001);
    System.out.println("Done.");

    System.out.println();
    System.out.println();
    System.out.println(clusters.size());
  }
}
