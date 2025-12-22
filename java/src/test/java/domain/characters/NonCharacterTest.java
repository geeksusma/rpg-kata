package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NonCharacterTest {

  @Test
  void should_createThingWithFixedLife_when_nonCharacter() {

    assertThat(NonCharacter.withHealth(2000)).hasFieldOrPropertyWithValue("health", Health.fixed(2000));
  }

  @Test
  void should_beDestroyed_when_noMoreHealth() {

    assertThat(NonCharacter.withHealth(2000).isDestroyed()).isFalse();
    assertThat(NonCharacter.withHealth(0).isDestroyed()).isTrue();
  }
}
