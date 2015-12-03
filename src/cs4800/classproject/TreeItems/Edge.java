package cs4800.classproject.TreeItems;

/**
 * To represent an edge
 */
public final class Edge implements Comparable {
  private final double weight;
  private final Vertex start;
  private final Vertex end;

  /**
   * To construct a {@link Edge}
   * @param weight weight of this {@link Edge}
   * @param start start {@link Vertex} of this {@link Edge}
   * @param end end {@link Vertex} of this {@link Edge}
   */
  public Edge(double weight, Vertex start, Vertex end) {
    this.weight = weight;
    this.start = start;
    this.end = end;
  }

  /**
   * To get weight of this {@link Edge}
   * @return the weight of this {@link Edge}
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * To get the start {@link Vertex} of this {@link Edge}
   * @return the {@link Vertex} of this {@link Edge}
   */
  public Vertex getStart() {
    return this.start;
  }

  /**
   * To get the end {@link Vertex} of this {@link Edge}
   * @return the end {@link Vertex} of this {@link Edge}
   */
  public Vertex getEnd() {
    return this.end;
  }

  /**
   * To print a {@link Edge} for testing
   * @return a string representation for a {@link Edge}
   */
  @Override
  public String toString() {
    return "Edge{" +
        "weight=" + weight +
        ", start=" + start +
        ", end=" + end +
        '}';
  }

  /**
   * To check if this {@link Edge} is equals to a given {@link Object}
   * @param o the given {@link Override}
   * @return a boolean depending if the given {@link Object} is equals to
   *         this {@link Edge}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Edge edge = (Edge) o;

    return Double.compare(edge.getWeight(), getWeight()) == 0 && !(getStart() != null ?
        !getStart().equals(edge.getStart()) :
        edge.getStart() != null) && !(getEnd() != null ?
        !getEnd().equals(edge.getEnd()) :
        edge.getEnd() != null);
  }

  /**
   * To calculate the hash code for this {@link Edge}
   * @return the hash code for this {@link Edge}
   */
  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(getWeight());
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
    result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
    return result;
  }

  /**
   * To compare this {@link Edge} to the given {@code e} based on their
   * respective weights
   * @param o the given {@link Object}
   * @return an integer base on this {@link Edge} and the give {@code e}
   *         weights
   */
  @Override
  public int compareTo(Object o) {
    Edge e = (Edge) o;
    return (int) this.getWeight() - (int) e.getWeight();
  }
}
