package domain.characters;

public class NonCharacter implements Target {

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

  @Override
  public void damage(int damage) {
    this.health.reduce(damage);
  }

  @Override
  public int level() {
    return 1;
  }

  @Override
  public boolean isAlly(Target target) {
    return false;
  }
}
