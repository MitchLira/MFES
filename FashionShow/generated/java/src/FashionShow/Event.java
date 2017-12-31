package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Event {
  public String name;
  public String place;
  public Platform.Date date;
  public String theme;
  public Number price;
  public VDMSet designers = SetUtil.set();
  public Number maxSpectators;
  public VDMSet audience = SetUtil.set();

  public void cg_init_Event_1(
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

  public Event(
      final String n,
      final Platform.Date d,
      final String p,
      final String t,
      final Number pr,
      final Number maxS) {

    cg_init_Event_1(n, Utils.copy(d), p, t, pr, maxS);
  }

  public void registerUser(final User user) {

    audience = SetUtil.union(Utils.copy(audience), SetUtil.set(user));
    user.setBudget(user.budget.doubleValue() - price.doubleValue());
  }

  public void refundUser(final User user) {

    audience = SetUtil.diff(Utils.copy(audience), SetUtil.set(user));
    user.setBudget(user.budget.doubleValue() + price.doubleValue());
  }

  public void addDesigner(final Designer designer) {

    designers = SetUtil.union(Utils.copy(designers), SetUtil.set(designer));
  }

  public void removeDesigner(final Designer designer) {

    designers = SetUtil.diff(Utils.copy(designers), SetUtil.set(designer));
  }

  public Event() {}

  public String toString() {

    return "Event{"
        + "name := "
        + Utils.toString(name)
        + ", place := "
        + Utils.toString(place)
        + ", date := "
        + Utils.toString(date)
        + ", theme := "
        + Utils.toString(theme)
        + ", price := "
        + Utils.toString(price)
        + ", designers := "
        + Utils.toString(designers)
        + ", maxSpectators := "
        + Utils.toString(maxSpectators)
        + ", audience := "
        + Utils.toString(audience)
        + "}";
  }
}
