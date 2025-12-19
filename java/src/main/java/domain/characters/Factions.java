package domain.characters;

import java.util.HashSet;
import java.util.Set;

public class Factions {

  private final Set<String> values = new HashSet<>();

  public static Factions init() {
    return new Factions();
  }

  public void join(String faction) {
    values.add(faction);
  }

  public void leave(String faction) {
    values.remove(faction);
  }
}
