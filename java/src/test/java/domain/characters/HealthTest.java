package domain.characters;

import org.assertj.core.api.Assertions;
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

  @Test
  void should_throwIsDead_when_healingACorpse() {

    //When
    Throwable error = Assertions.catchThrowable(() -> corpse().heal(1));

    //Then
    assertThat(error).isInstanceOf(IsDead.class);
  }

  @Test
  void should_recoverHeal_when_healingNotACorpse() {
    //Given
    Health notACorpse = damagedHeal();
    //When
    notACorpse.heal(1);

    // then
    assertThat(notACorpse).hasFieldOrPropertyWithValue("value", Health.INITIAL_HEALTH - 99);
  }

  @Test
  void should_goBackToDefaultHeal_when_healExceeded() {
    //Given
    Health almostDead = Health.init();
    almostDead.reduce(999);

    //When
    almostDead.heal(9999);

    //Then
    assertThat(almostDead.value()).isEqualTo(Health.INITIAL_HEALTH);
  }

  @Test
  void should_createWithFixedLife_when_fixed() {
    //Given
    int expectedLife = 2000;

    //When
    Health fixed = Health.fixed(expectedLife);

    //Then
    assertThat(fixed.value()).isEqualTo(expectedLife);
  }

  private static Health damagedHeal() {
    Health notACorpse = Health.init();
    notACorpse.reduce(100);
    return notACorpse;
  }

  private Health corpse() {
    Health toBeDeath = Health.init();
    toBeDeath.reduce(10000);
    return toBeDeath;
  }
}
