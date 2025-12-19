package domain.characters;

public class Attack {
  private final Character target;
  private final int damage;

  private Attack(Character target, int damage) {
    this.target = target;
    this.damage = damage;
  }

  public static Attack of(Character target, int damage) {
    return new Attack(target, damage);
  }

  public Character getTarget() {
    return target;
  }

  public int getDamage() {
    return damage;
  }
}
