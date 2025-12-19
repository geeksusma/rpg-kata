package domain.characters;

public enum Fighter {
  MELEE(2), RANGED(20);

  private final int rangeInMeters;

  Fighter(int rangeInMeters) {
    this.rangeInMeters = rangeInMeters;
  }

  public int meters() {
    return rangeInMeters;
  }
}
