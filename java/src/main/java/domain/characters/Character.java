package domain.characters;

public class Character {

  private final Health health;

  private final Level level;

  private final Fighter fighter;

  private Character(Fighter fighter) {
    this.health = Health.init();
    this.level = Level.init();
    this.fighter = fighter;
  }

  public static Character ranged() {
    return init(Fighter.RANGED);
  }

  public static Character melee() {
    return init(Fighter.MELEE);
  }

  public boolean isAlive() {
    return this.health.isAlive();
  }

  public int health() {
    return health.value();
  }

  public int level() {
    return level.value();
  }

  public void damage(int damage) {
    health.reduce(damage);
  }

  public void heal(int heal) {
    health.heal(heal);
  }

  public void increaseLevels(int levelsToAdd) {
    level.increase(levelsToAdd);
  }

  private static Character init(Fighter fighter) {
    return new Character(fighter);
  }
}
