package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
