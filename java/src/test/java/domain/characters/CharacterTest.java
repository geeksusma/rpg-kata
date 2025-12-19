package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CharacterTest {

  @Test
  void should_initWithDefaultHealth_when_newCharacter() {

    assertThat(Character.melee())
      .satisfies(character -> {
        assertThat(character).hasFieldOrPropertyWithValue("health", Health.init());
      });
  }

  @Test
  void should_initWithDefaultLevel_when_newCharacter() {

    assertThat(Character.melee())
      .satisfies(character -> {
        assertThat(character).hasFieldOrPropertyWithValue("level", Level.init());
      });
  }

  @Test
  void should_initCharacterAliveInLevelOneWithDefaultHealth_when_newCharacter() {

    //When
    Character newCharacter = Character.melee();

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
    Character damagedCharacter = Character.melee();
    //When
    damagedCharacter.damage(1);
    //Then
    assertThat(damagedCharacter.health()).isLessThan(Health.INITIAL_HEALTH);
  }

  @Test
  void should_recoverHealth_when_healed() {
    //Given
    int expectedHeal = 500;
    Character aCharacter = Character.melee();
    aCharacter.damage(600);

    //When
    aCharacter.heal(100);

    //Then
    assertThat(aCharacter.health()).isEqualTo(expectedHeal);
  }

  @Test
  void should_cantFightWithMyself_when_fight() {
    //Given
    Character aCharacter = Character.melee();

    //When
    Throwable error = catchThrowable(() -> aCharacter.fight(aCharacter, 1));

    //Then
    assertThat(error).isInstanceOf(IllegalFight.class);
  }

  @Test
  void should_targetLoseHealth_when_attacked() {
    //Given
    Character target = Character.melee();
    Character attacker = Character.melee();

    //When
    attacker.fight(target, 1);

    //Then
    assertThat(target.health()).isLessThan(Health.INITIAL_HEALTH);
  }

  @Test
  void should_reducedDamage_when_targetLevelIsFiveLevelsAbove() {
    //Given
    Character target = Character.melee();
    target.increaseLevels(5);

    Character attacker = Character.melee();

    //When
    attacker.fight(target, 10);

    //Then
    assertThat(target.health()).isEqualTo(995);
  }

  @Test
  void should_increasedDamage_when_targetLevelIsFiveLevelsBelow() {
    //Given
    Character target = Character.melee();
    Character attacker = Character.melee();
    attacker.increaseLevels(5);

    //When
    attacker.fight(target, 10);

    //Then
    assertThat(target.health()).isEqualTo(980);
  }

  @Test
  void should_createAMeleeFighter_when_melee() {

    assertThat(Character.melee()).hasFieldOrPropertyWithValue("fighter", Fighter.MELEE);
  }

  @Test
  void should_createARangedFighter_when_ranged() {

    assertThat(Character.ranged()).hasFieldOrPropertyWithValue("fighter", Fighter.RANGED);
  }
}
