package org.quicktheories.quicktheories.generators;

public class SourceDSL {

  public static LongsDSL longs() {
    return new LongsDSL();
  }

  public static IntegersDSL integers() {
    return new IntegersDSL();
  }

  public static DoublesDSL doubles() {
    return new DoublesDSL();
  }

  public static FloatsDSL floats() {
    return new FloatsDSL();
  }

  public static CharactersDSL characters() {
    return new CharactersDSL();
  }

  public static StringsDSL strings() {
    return new StringsDSL();
  }

  public static ListsDSL lists() {
    return new ListsDSL();
  }

  public static ArraysDSL arrays() {
    return new ArraysDSL();
  }

  public static BigIntegersDSL bigIntegers() {
    return new BigIntegersDSL();
  }

  public static BigDecimalsDSL bigDecimals() {
    return new BigDecimalsDSL();
  }

  public static ArbitraryDSL arbitrary() {
    return new ArbitraryDSL();
  }

}
