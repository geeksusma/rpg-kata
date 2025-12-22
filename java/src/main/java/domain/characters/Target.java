package domain.characters;

public interface Target {

  void damage(int health);

  int level();

  boolean isAlly(Target target);
}
