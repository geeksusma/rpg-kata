package domain.characters;

public class Heal {
  private final Character source;
  private final Character target;
  private final int health;

  private Heal(Character source, Character target, int health) {
    this.source = source;
    this.target = target;
    this.health = health;
  }

  public static Heal of(Character source, Character target, int health) {
    return new Heal(source, target, health);
  }

  public void heal() {
    if (theyAreEnemies()) {
      throw new IllegalHeal();
    }
    target.heal(this.health);
  }

  private boolean theyAreEnemies() {
    return !source.equals(target) && !source.isAlly(target);
  }
}
