package org.quicktheories.quicktheories.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.quicktheories.quicktheories.api.Tuple3;
import org.quicktheories.quicktheories.api.Tuple4;

import nl.jqno.equalsverifier.EqualsVerifier;

public class Tuple3Test {

  @Test
  public void shouldDisplayAllDataInToString() {
    Tuple3<Integer, String, Integer> testee = Tuple3.of(42, "foo", 13);
    assertThat(testee.toString()).isEqualTo("{42, foo, 13}");
  }

  @Test
  public void shouldPrependDataToFromTuple4() {
    Tuple3<Integer, String, Integer> testee = Tuple3.of(42, "foo", 13);
    Tuple4<String, Integer, String, Integer> actual = testee.prepend("boo");
    assertThat(actual).isEqualTo(Tuple4.of("boo", 42, "foo", 13));
  }

  @Test
  public void shouldExtendToRightBasedOnOwnContents() {
    Tuple3<Integer, String, Integer> testee = Tuple3.of(42, "foo", 13);
    Tuple4<Integer, String, Integer, String> actual = testee
        .extend((a, b, c) -> "" + a + b + c);
    assertThat(actual).isEqualTo(Tuple4.of(42, "foo", 13, "42foo13"));
  }

  @Test
  public void shouldObeyHashcodeEqualsContract() {
    EqualsVerifier.forClass(Tuple3.class).allFieldsShouldBeUsed().verify();
  }
}
