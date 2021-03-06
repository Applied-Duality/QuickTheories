package org.quicktheories.quicktheories.generators;

import java.math.BigDecimal;

import org.quicktheories.quicktheories.core.Source;
import org.quicktheories.quicktheories.generators.BigIntegersDSL.BigIntegers;

/**
 * A Class for creating BigDecimal Sources
 *
 */
public class BigDecimalsDSL {

  /**
   * Creates a BigDecimalsBuilder that can be used to create BigDecimals
   * 
   * @param maxNumberOfBytes
   *          the maximum number of bytes of a BigInteger from which a
   *          BigDecimal would be composed
   * @return a BigDecimalsBuilder
   */
  public BigDecimalsBuilder ofBytes(int maxNumberOfBytes) {
    return new BigDecimalsBuilder(maxNumberOfBytes);
  }

  public class BigDecimalsBuilder {

    private final int maxLengthOfBigIntegerByteArray;

    private BigDecimalsBuilder(int maxLengthOfBigIntegerByteArray) {
      ArgumentAssertions.checkArguments(maxLengthOfBigIntegerByteArray > 0,
          "The length of this array cannot be less than one; %s is not an accepted argument",
          maxLengthOfBigIntegerByteArray);
      this.maxLengthOfBigIntegerByteArray = maxLengthOfBigIntegerByteArray;
    }

    /**
     * Generates BigDecimals of specified scale from BigIntegers constructed
     * from Byte arrays of a given maximum size
     * 
     * @param scale
     *          - the desired scale of the BigDecimal
     * @return a Source of type BigDecimal
     */
    public Source<BigDecimal> withScale(int scale) {
      return BigDecimals.randomWithScale(maxLengthOfBigIntegerByteArray, scale);
    }
  }

  final static class BigDecimals {

    static Source<BigDecimal> randomWithScale(
        int maxLengthOfBigIntegerByteArray, int scale) {
      return BigIntegers.random(maxLengthOfBigIntegerByteArray).as(
          i -> new BigDecimal(i, scale),
          d -> d.movePointRight(scale).toBigInteger());
    }

  }
}
