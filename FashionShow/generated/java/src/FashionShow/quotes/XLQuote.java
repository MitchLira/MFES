package FashionShow.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class XLQuote {
  private static int hc = 0;
  private static XLQuote instance = null;

  public XLQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static XLQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new XLQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof XLQuote;
  }

  public String toString() {

    return "<XL>";
  }
}
