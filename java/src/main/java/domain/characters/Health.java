package domain.characters;

import java.util.Objects;

public class Health {

  static final int INITIAL_HEALTH = 1000;
  private int value;

  private Health() {
    this.value = INITIAL_HEALTH;
  }

  public static Health init() {
    return new Health();
  }

  public int value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Health health = (Health) o;
    return value == health.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  public void reduce(int damage) {
    this.value = this.value - damage;
  }

  public boolean isAlive() {
    return this.value > 0;
  }
}
