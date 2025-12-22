package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class HealTest {

  @Test
  void should_heal_when_healingMySelf() {
    //Given
    Character melee = Character.melee();
    melee.damage(10);

    Heal heal = Heal.of(melee, melee, 10);

    //When
    heal.heal();

    //Then
    assertThat(melee.health()).isEqualTo(Health.INITIAL_HEALTH);
  }


  @Test
  void should_illegalHealing_when_healedByEnemies() {
    //Given
    Character ranged = Character.ranged();
    ranged.join("enemy");

    Character melee = Character.melee();
    melee.join("friend");
    melee.damage(10);

    Heal heal = Heal.of(ranged, melee, 10);

    //When
    Throwable error = catchThrowable(heal::heal);

    //Then
    assertThat(error).isInstanceOf(IllegalHeal.class);
  }

  @Test
  void should_heal_when_healedByFriend() {
    //Given
    Character ranged = Character.ranged();
    ranged.join("friend");

    Character melee = Character.melee();
    melee.join("friend");
    melee.damage(10);

    Heal heal = Heal.of(ranged, melee, 10);

    //When
    heal.heal();

    //Then
    assertThat(melee.health()).isEqualTo(Health.INITIAL_HEALTH);
  }
}
