package ch.heigvd.api.labio.impl.transformers;

import java.util.logging.Logger;

/**
 * This class applies a transformation to the input character (a string with a single character):
 *   1. Convert all line endings to Unix-style line endings, i.e. only '\n'.
 *   2. Add a line number at the beginning of each line.
 * Example:
 *   Using this character transformer, the following file :
 *      This is the first line.\r\n
 *      This is the second line.
 *   will be transformed to:
 *      1. This is the first line.\n
 *      2. This is the second line.
 *
 * @author Olivier Liechti, Juergen Ehrensberger
 */
public class LineNumberingCharTransformer {
  private static final Logger LOG = Logger.getLogger(LineNumberingCharTransformer.class.getName());

  public String transform(String c) {
    /* TODO: implement the transformation here.
     */
    c  = c.replace("\r", "");

    c = "1. " + c;

    int counter = 2;

    int i = 0;

    while (i < c.length()) {
      if (c.charAt(i) == '\n') {
        c = c.substring(0, i + 1) + counter + ". " + c.substring(i + 1);
        counter++;
      }
    }

    return c;
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }
}
