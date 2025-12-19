package domain.characters;

public class Attack {
  private final Character source;
  private final Character target;
  private int damage;
  private int distance;

  private Attack(Character source, Character target, int damage, int distance) {
    this.source = source;
    this.target = target;
    this.damage = damage;
    this.distance = distance;
  }

  public static Attack of(Character source, Character target, int damage, int distance) {
    return new Attack(source, target, damage, distance);
  }


  public void fight() {
    avoidFightIfTargetAndSourceAreTheSame();
    if (fightersAreInRange()) {
      calculateDamage();
      target.damage(damage);
    }
  }

  private boolean fightersAreInRange() {
    return source.range() >= distance;
  }

  private void calculateDamage() {
    damage = reduceIfTargetIsQuiteBiggerThanSource();
    damage = doubleIfTargetIsQuiteBelowThanSource();
  }

  private int doubleIfTargetIsQuiteBelowThanSource() {
    if (source.level() - target.level() >= 5) {
      damage = damage * 2;
    }
    return damage;
  }

  private int reduceIfTargetIsQuiteBiggerThanSource() {
    if (target.level() - source.level() >= 5) {
      damage = damage / 2;
    }
    return damage;
  }

  private void avoidFightIfTargetAndSourceAreTheSame() {
    if (target.equals(source)) {
      throw new IllegalFight();
    }
  }
}
