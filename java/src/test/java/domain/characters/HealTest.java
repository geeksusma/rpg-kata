package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
  void should_skipHealing_when_healingByOther() {
    //Given
    Character ranged = Character.ranged();
    Character melee = Character.melee();
    melee.damage(10);

    Heal heal = Heal.of(ranged, melee, 10);

    //When
    heal.heal();

    //Then
    assertThat(melee.health()).isEqualTo(Health.INITIAL_HEALTH - 10);
  }
}
