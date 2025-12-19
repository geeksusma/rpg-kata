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
    return this.health.isAlive();
  }

  public int health() {
    return health.value();
  }

  public int level() { return level.value(); }

  public void damage(int damage) {
    health.reduce(damage);
  }

  public void heal(int heal) {
    health.heal(heal);
  }

  public void fight(Character target, int damage) {
    assertNotFightingAgainstMe(target);
    damage = calculateDamage(target, damage);
    target.damage(damage);
  }

  private int calculateDamage(Character target, int damage) {
    damage = reduceIfTargetIsQuiteBiggerThanMe(target, damage);
    damage = doubleIfTargetIsQuiteBelowThanMe(target, damage);
    return damage;
  }

  private int doubleIfTargetIsQuiteBelowThanMe(Character target, int damage) {
    if(this.level() - target.level() >= 5){
      damage = damage * 2;
    }
    return damage;
  }

  private int reduceIfTargetIsQuiteBiggerThanMe(Character target, int damage) {
    if(target.level() - this.level() >= 5){
      damage = damage / 2;
    }
    return damage;
  }

  private void assertNotFightingAgainstMe(Character target) {
    if (target.equals(this)) {
      throw new IllegalFight();
    }
  }

  public void increaseLevels(int levelsToAdd) {
    level.increase(levelsToAdd);
  }
}
