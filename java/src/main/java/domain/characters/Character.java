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
    return 1000;
  }

  public int level() {
    return 1;
  }
}
