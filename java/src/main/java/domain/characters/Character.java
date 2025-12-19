package domain.characters;

public class Character {

  private final Health health;

  private final Level level;

  public Character() {
    this.health = Health.init();
    this.level = Level.init();
  }

  public static Character init() {
    return new Character();
  }

  public boolean isAlive() {
    return true;
  }

  public int health() {
    return health.value();
  }

  public int level() {
    return 1;
  }

  public void damage(int damage) {
    health.reduce(damage);
  }
}
