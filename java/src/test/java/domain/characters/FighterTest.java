package domain.characters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FighterTest {

  @Test
  void should_has2MetersRange_when_Melee() {

    assertThat(Fighter.MELEE.meters())
      .isEqualTo(2);
  }

  @Test
  void should_has2MetersRange_when_Ranged() {

    assertThat(Fighter.RANGED.meters())
      .isEqualTo(20);
  }
}
