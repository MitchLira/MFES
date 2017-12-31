package FashionShow.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class XXLQuote {
  private static int hc = 0;
  private static XXLQuote instance = null;

  public XXLQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static XXLQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new XXLQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof XXLQuote;
  }

  public String toString() {

    return "<XXL>";
  }
}
