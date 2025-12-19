package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CharacterTest {

  @Test
  void should_initWithDefaultHealth_when_newCharacter() {

    assertThat(Character.init())
      .satisfies(character -> {
        assertThat(character).hasFieldOrPropertyWithValue("health", Health.init());
      });
  }

  @Test
  void should_initWithDefaultLevel_when_newCharacter() {

    assertThat(Character.init())
      .satisfies(character -> {
        assertThat(character).hasFieldOrPropertyWithValue("level", Level.init());
      });
  }

  @Test
  void should_initCharacterAliveInLevelOneWithDefaultHealth_when_newCharacter() {

    //When
    Character newCharacter = Character.init();

    //Then
    assertThat(newCharacter).satisfies(character -> {
      assertThat(character.isAlive()).isTrue();
      assertThat(character.health()).isEqualTo(Health.INITIAL_HEALTH);
      assertThat(character.level()).isEqualTo(1);
    });
  }

  @Test
  void should_loseHealth_when_damaged() {
    //Given
    Character damagedCharacter = Character.init();
    //When
    damagedCharacter.damage(1);
    //Then
    assertThat(damagedCharacter.health()).isLessThan(Health.INITIAL_HEALTH);
  }

  @Test
  void should_recoverHealth_when_healed() {
    //Given
    int expectedHeal = 500;
    Character aCharacter = Character.init();
    aCharacter.damage(600);

    //When
    aCharacter.heal(100);

    //Then
    assertThat(aCharacter.health()).isEqualTo(expectedHeal);
  }

  @Test
  void should_cantFightWithMyself_when_fight() {
    //Given
    Character aCharacter = Character.init();

    //When
    Throwable error = catchThrowable(() -> aCharacter.fight(aCharacter, 1));

    //Then
    assertThat(error).isInstanceOf(IllegalFight.class);
  }

  @Test
  void should_targetLoseHealth_when_attacked() {
    //Given
    Character target = Character.init();
    Character attacker = Character.init();

    //When
    attacker.fight(target, 1);

    //Then
    assertThat(target.health()).isLessThan(Health.INITIAL_HEALTH);
  }

  @Test
  void should_reducedDamage_when_targetLevelIsFiveLevelsAbove() {
    //Given
    Character target = Character.init();
    target.increaseLevels(5);

    Character attacker = Character.init();

    //When
    attacker.fight(target, 10);

    //Then
    assertThat(target.health()).isEqualTo(995);
  }

  @Test
  void should_increasedDamage_when_targetLevelIsFiveLevelsBelow() {
    //Given
    Character target = Character.init();
    Character attacker = Character.init();
    attacker.increaseLevels(5);

    //When
    attacker.fight(target, 10);

    //Then
    assertThat(target.health()).isEqualTo(980);
  }

}
