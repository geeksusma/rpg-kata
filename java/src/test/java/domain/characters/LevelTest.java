package domain.characters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LevelTest {

  @Test
  void should_startInLevelOne_when_created() {

    //When
    Level initialLevel = Level.init();

    //Then
    assertThat(initialLevel).hasFieldOrPropertyWithValue("value", 1);
  }


}
