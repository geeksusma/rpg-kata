package domain.characters;

public class Attack {
  private final Character source;
  private final Character target;
  private int damage;

  private Attack(Character source, Character target, int damage) {
    this.source = source;
    this.target = target;
    this.damage = damage;
  }

  public static Attack of(Character source, Character target, int damage) {
    return new Attack(source, target, damage);
  }


  public void fight() {
    avoidFightIfTargetAndSourceAreTheSame();
    calculateDamage();
    target.damage(damage);
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
