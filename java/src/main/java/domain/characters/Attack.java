package domain.characters;

public class Attack {

  private final Rivals rivals;
  private final BattleData battleData;

  private Attack(Character source, Target target, int damage, int distance) {
    this.rivals = Rivals.with(source, target);
    this.battleData = BattleData.with(distance, damage);
  }

  public static Attack of(Character source, Target target, int damage, int distance) {
    return new Attack(source, target, damage, distance);
  }


  public void fight() {
    avoidFightIfTargetAndSourceAreTheSame();
    if (fightersAreInRange() && rivals.theyAreEnemies()) {
      rivals.damage(calculateDamage());
    }
  }


  private boolean fightersAreInRange() {
    return rivals.sourceRange() >= battleData.distance();
  }

  private int calculateDamage() {
    int damage;
    damage = reduceIfTargetIsQuiteBiggerThanSource();
    if (damage == battleData.damage()) {
      damage = doubleIfTargetIsQuiteBelowThanSource();
    }
    return damage;
  }

  private int doubleIfTargetIsQuiteBelowThanSource() {
    if (rivals.canIncreaseDamage()) {
      return battleData.damage() * 2;
    }
    return battleData.damage();
  }

  private int reduceIfTargetIsQuiteBiggerThanSource() {
    if (rivals.canReduceDamage()) {
      return battleData.damage() / 2;
    }
    return battleData.damage();
  }

  private void avoidFightIfTargetAndSourceAreTheSame() {
    if (rivals.sourceIsTarget()) {
      throw new IllegalFight();
    }
  }
}
