package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Presentation extends Event {
  public void cg_init_Presentation_1(
      final String n,
      final Platform.Date d,
      final String p,
      final String t,
      final Number pr,
      final Number maxS) {

    name = n;
    date = Utils.copy(d);
    place = p;
    theme = t;
    price = pr;
    maxSpectators = maxS;
    return;
  }

  public Presentation(
      final String n,
      final Platform.Date d,
      final String p,
      final String t,
      final Number pr,
      final Number maxS) {

    cg_init_Presentation_1(n, Utils.copy(d), p, t, pr, maxS);
  }

  public Presentation() {}

  public String toString() {

    return "Presentation{}";
  }
}
