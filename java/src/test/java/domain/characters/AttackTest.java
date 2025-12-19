package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class AttackTest {

  @Test
  void should_cantFightWithMyself_when_fight() {
    //Given
    Character aCharacter = Character.melee();

    //When
    Throwable error = catchThrowable(() -> Attack.of(aCharacter, aCharacter, 10, 1).fight());

    //Then
    assertThat(error).isInstanceOf(IllegalFight.class);
  }

  @Test
  void should_targetLoseHealth_when_attacked() {
    //Given
    Character target = Character.melee();
    Character attacker = Character.melee();

    //When
    Attack.of(attacker, target, 10, 1).fight();

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
    Attack.of(attacker, target, 10, 1).fight();

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
    Attack.of(attacker, target, 10, 1).fight();

    //Then
    assertThat(target.health()).isEqualTo(980);
  }

  @Test
  void should_fight_when_inRange() {
    //Given
    Character source = Character.ranged();
    Character target = Character.melee();

    //When
    Attack.of(source, target, 10, 10).fight();
    //Then
    assertThat(target.health()).isEqualTo(990);
  }

  @Test
  void should_skipFight_when_notInRange() {
    //Given
    Character source = Character.melee();
    Character target = Character.melee();

    //When
    Attack.of(source, target, 10, 3).fight();

    //Then
    assertThat(target.health()).isEqualTo(Health.INITIAL_HEALTH);
  }

}
