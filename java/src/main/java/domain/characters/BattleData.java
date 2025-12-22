package domain.characters;

public class BattleData {

  private final int damage;
  private final int distance;

  private BattleData(int distance, int damage) {
    this.distance = distance;
    this.damage = damage;
  }

  public static BattleData with(int distance, int damage) {
    return new BattleData(distance, damage);
  }

  public int damage() {
    return damage;
  }

  public int distance() {
    return distance;
  }
}
