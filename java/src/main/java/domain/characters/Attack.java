package domain.characters;

public class Attack {

  private final Rivals rivals;
  private int damage;
  private final int distance;

  private Attack(Character source, Target target, int damage, int distance) {
    this.rivals = Rivals.with(source, target);
    this.damage = damage;
    this.distance = distance;
  }

  public static Attack of(Character source, Target target, int damage, int distance) {
    return new Attack(source, target, damage, distance);
  }


  public void fight() {
    avoidFightIfTargetAndSourceAreTheSame();
    if (fightersAreInRange() && rivals.theyAreEnemies()) {
      calculateDamage();
      rivals.damage(damage);
    }
  }


  private boolean fightersAreInRange() {
    return rivals.sourceRange() >= distance;
  }

  private void calculateDamage() {
    damage = reduceIfTargetIsQuiteBiggerThanSource();
    damage = doubleIfTargetIsQuiteBelowThanSource();
  }

  private int doubleIfTargetIsQuiteBelowThanSource() {
    if (rivals.canIncreaseDamage()) {
      damage = damage * 2;
    }
    return damage;
  }

  private int reduceIfTargetIsQuiteBiggerThanSource() {
    if (rivals.canReduceDamage()) {
      damage = damage / 2;
    }
    return damage;
  }

  private void avoidFightIfTargetAndSourceAreTheSame() {
    if (rivals.sourceIsTarget()) {
      throw new IllegalFight();
    }
  }
}
