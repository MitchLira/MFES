package FashionShow.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class XSQuote {
  private static int hc = 0;
  private static XSQuote instance = null;

  public XSQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static XSQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new XSQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof XSQuote;
  }

  public String toString() {

    return "<XS>";
  }
}
