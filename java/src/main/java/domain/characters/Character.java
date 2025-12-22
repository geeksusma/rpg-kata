package domain.characters;

import java.util.List;

public class Character implements Target {

  private final Health health;

  private final Level level;

  private final Fighter fighter;

  private final Factions factions;

  private Character(Fighter fighter) {
    this.health = Health.init();
    this.level = Level.init();
    this.fighter = fighter;
    this.factions = Factions.init();
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

  public int range() {
    return fighter.meters();
  }

  public boolean hasFactions() {
    return !factions.isEmpty();
  }

  public void join(String faction) {
    factions.join(faction);
  }

  public void leave(String faction) {
    factions.leave(faction);
  }

  public boolean isAlly(Target target) {
    boolean isAlly = false;
    List<String> myFactions = myFactions();
    isAlly = isAnAlly(target, myFactions, isAlly);
    return isAlly;
  }

  private static boolean isAnAlly(Target target, List<String> myFactions, boolean isAlly) {
    if (target instanceof NonCharacter) {
      return false;
    }
    for (int counter = 0; counter < myFactions.size() && !isAlly; counter++) {
      isAlly = ((Character) target).factions.isFriend(myFactions.get(counter));
    }
    return isAlly;
  }

  private List<String> myFactions() {
    return this.factions.values();
  }
}
