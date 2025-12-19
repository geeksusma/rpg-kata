package domain.characters;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FactionsTest {


  @Test
  void should_subscribeToFaction_when_join() {
    //Given
    Factions factions = Factions.init();
    String faction = "A Faction";

    //When
    factions.join(faction);

    //Then
    assertThat(factions).hasFieldOrPropertyWithValue("values", new HashSet<>(List.of(faction)));
  }

  @Test
  void should_skipFaction_when_alreadyJoined() {
    //Given
    Factions factions = Factions.init();
    String faction = "A Faction";

    //When
    factions.join(faction);
    factions.join(faction);

    //Then
    assertThat(factions).hasFieldOrPropertyWithValue("values", new HashSet<>(List.of(faction)));
  }

  @Test
  void should_leaveFaction_when_left() {
    //Given
    Factions factions = Factions.init();
    String faction = "A Faction";
    factions.join(faction);

    //When
    factions.leave(faction);

    //Then
    assertThat(factions).hasFieldOrPropertyWithValue("values", new HashSet<>());
  }
}
