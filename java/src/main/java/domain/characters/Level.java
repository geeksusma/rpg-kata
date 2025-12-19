package domain.characters;

import java.util.Objects;

public class Level {

  private int value;

  private Level() {
    this.value = 1;
  }

  public static Level init() {
    return new Level();
  }

  public int value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {

    if (o == null || getClass() != o.getClass()) return false;
    Level level = (Level) o;
    return value == level.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  public void increase(int level) {
    this.value = this.value + level;
  }
}
