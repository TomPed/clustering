package cs4800.classproject.Utilities;

/**
 * To represent the different types of "things"
 */
public enum Classes {
  BRICKFACE, SKY, FOLIAGE, CEMENT, WINDOW, PATH, GRASS;

  /**
   * To turn a string into a {@link Classes}
   * @param s the given string
   * @return the correct {@link Classes}
   * @throws IllegalStateException if no such {@code s} exists in
   *                               {@link Classes}
   */
  public static Classes toEnum(String s) throws IllegalStateException {
    switch (s) {
      case "brickface":
        return BRICKFACE;
      case "sky":
        return SKY;
      case "foliage":
        return FOLIAGE;
      case "cement":
        return CEMENT;
      case "window":
        return WINDOW;
      case "path":
        return PATH;
      case "grass":
        return GRASS;
      default:
        throw new IllegalArgumentException("No such enum type");
    }
  }
}
