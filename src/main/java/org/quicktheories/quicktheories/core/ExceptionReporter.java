package org.quicktheories.quicktheories.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Interface that reports the falsification of properties
 *
 */
public class ExceptionReporter implements Reporter {

  @Override
  public void falisification(long seed, int examplesUsed, Object smallest,
      List<Object> examples) {
    this.falsify(seed, examplesUsed, smallest, "", examples);

  }

  @Override
  public void valuesExhausted(int completedExamples) {
    throw new IllegalStateException(
        String.format(
            "Gave up after finding only %s example(s) matching the assumptions",
            completedExamples));
  }

  @Override
  public void falisification(long seed, int examplesUsed, Object smallest,
      Throwable cause, List<Object> examples) {
    StringWriter sw = new StringWriter();
    cause.printStackTrace(new PrintWriter(sw));
    String failure = "\nCause was :-\n" + sw.toString();
    this.falsify(seed, examplesUsed, smallest, failure, examples);
  }

  private void falsify(long seed, int examplesUsed, Object smallest,
      String failure, List<Object> examples) {
    throw new AssertionError(String.format(
        "Property falsified after %s example(s) \nSmallest found falsifying value(s) :-\n%s%s\nOther found falsifying value(s) :- \n%s\n \nSeed was %s",
        examplesUsed, smallest, failure,
        examples.stream()
            .limit(10)
            .map(o -> o.toString())
            .collect(Collectors.joining("\n")),
        seed));

  }

}
