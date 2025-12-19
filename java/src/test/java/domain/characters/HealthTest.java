package domain.characters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HealthTest {

  @Test
  void should_initialHealthToDefault_when_created() {

    //When
    Health initialHealth = Health.init();

    //Then
    assertThat(initialHealth).hasFieldOrPropertyWithValue("value", Health.INITIAL_HEALTH);
  }

  @Test
  void should_loseHealth_when_reduce() {
    //Given
    Health initialHealth = Health.init();

    //When
    initialHealth.reduce(1);

    //Then
    assertThat(initialHealth.value()).isEqualTo(Health.INITIAL_HEALTH - 1);
  }

  @Test
  void should_returnAsDead_when_healthIsLowerOrEqualToZero() {
    //Give
    Health death = Health.init();

    //When
    death.reduce(Health.INITIAL_HEALTH);

    //Then
    assertThat(death.isAlive()).isFalse();
  }

  @Test
  void should_returnAsAlive_when_healthIsGreaterThanZero() {
    //Given
    Health alive = Health.init();
    //When
    alive.reduce(10);
    //Then
    assertThat(alive.isAlive()).isTrue();
  }
}
