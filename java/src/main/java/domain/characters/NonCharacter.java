package domain.characters;

public class NonCharacter {

  private final Health health;

  private NonCharacter(Health health) {
    this.health = health;
  }

  public static NonCharacter withHealth(int health) {
    return new NonCharacter(Health.fixed(health));
  }

  public boolean isDestroyed() {
    return !this.health.isAlive();
  }
}
