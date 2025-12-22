package domain.characters;

public class Rivals {
  private final Character source;
  private final Target target;

  private Rivals(Character source, Target target) {
    this.source = source;
    this.target = target;
  }

  public static Rivals with(Character source, Target target) {
    return new Rivals(source, target);
  }

  public void damage(int damage) {
    target.damage(damage);
  }

  public boolean theyAreEnemies() {
    return !source.isAlly(target);
  }


  public int sourceRange() {
    return source.range();
  }

  public boolean sourceIsTarget() {
    return source.equals(target);
  }

  public boolean canIncreaseDamage() {
    return source.level() - target.level() >= 5;
  }

  public boolean canReduceDamage() {
    return target.level() - source.level() >= 5;
  }
}
