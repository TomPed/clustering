package cs4800.classproject.TreeItems;

import cs4800.classproject.Utilities.Classes;

import java.util.ArrayList;

/**
 * To represent a vertex
 * NOTE: equality is only intentional
 */
public final class Vertex {
  private final Classes type;
  private final ArrayList<Double> data;

  /**
   * To construct a {@link Vertex}
   * @param type type of data for this {@link Vertex}
   * @param data given from the file for this {@link Vertex}
   */
  public Vertex(Classes type, ArrayList<Double> data) {
    this.type = type;
    this.data = data;
  }

  /**
   * To get the type of this {@link Vertex}
   * @return the type of this {@link Vertex}
   */
  public Classes getType() {
    return this.type;
  }

  /**
   * To get the data of this {@link Vertex}
   * @return the data of this {@link Vertex}
   */
  public ArrayList<Double> getData() {
    return this.data;
  }

  /**
   * To print a {@link Vertex} for testing
   * @return a string representation for a {@link Vertex}
   */
  @Override
  public String toString() {
    return "Vertex{" +
        "type=" + type +
        ", data=" + data +
        '}';
  }
}
