package FashionShow;

import java.io.Serializable;
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Platform implements Serializable{
  public Date actualDate;
  public VDMSet users;
  public VDMSet events;
  public VDMSet items;
  public VDMSet designers;

  public void cg_init_Platform_1(final Date actualD) {

    actualDate = Utils.copy(actualD);
    users = SetUtil.set();
    events = SetUtil.set();
    items = SetUtil.set();
    designers = SetUtil.set();
    return;
  }

  public Platform(final Date actualD) {

    cg_init_Platform_1(Utils.copy(actualD));
  }

  public void moveDataForward() {

    if (actualDate.day.longValue() + 1L > 30L) {
      actualDate.day = 1L;
      if (actualDate.month.longValue() + 1L > 12L) {
        actualDate.month = 1L;
        actualDate.year = actualDate.year.longValue() + 1L;

      } else {
        actualDate.month = actualDate.month.longValue() + 1L;
      }

    } else {
      actualDate.day = actualDate.day.longValue() + 1L;
    }
  }

  public void endDay() {

    moveDataForward();
    for (Iterator iterator_10 = events.iterator(); iterator_10.hasNext(); ) {
      Event event = (Event) iterator_10.next();
      if (Utils.equals(cg_Utils.isAfter(Utils.copy(actualDate), event.date), true)) {
        removeEvent(event);
      }
    }
  }

  public void addUser(final User user) {

    users = SetUtil.union(Utils.copy(users), SetUtil.set(user));
  }

  public void removeUser(final User user) {

    users = SetUtil.diff(Utils.copy(users), SetUtil.set(user));
  }

  public User getUserByUsername(final String username) {

    User user = null;
    for (Iterator iterator_11 = users.iterator(); iterator_11.hasNext(); ) {
      User u = (User) iterator_11.next();
      if (Utils.equals(u.username, username)) {
        user = u;
      }
    }
    return user;
  }

  public void addEvent(final Event event) {

    events = SetUtil.union(Utils.copy(events), SetUtil.set(event));
  }

  public void removeEvent(final Event event) {

    events = SetUtil.diff(Utils.copy(events), SetUtil.set(event));
  }

  public void addItem(final Item item) {

    items = SetUtil.union(Utils.copy(items), SetUtil.set(item));
  }

  public void removeItem(final Item item) {

    items = SetUtil.diff(Utils.copy(items), SetUtil.set(item));
  }

  public Item getItemByRef(final String ref) {

    Item item = null;
    for (Iterator iterator_12 = items.iterator(); iterator_12.hasNext(); ) {
      Item it = (Item) iterator_12.next();
      if (Utils.equals(it.reference, ref)) {
        item = it;
      }
    }
    return item;
  }

  public void addDesigner(final Designer designer) {

    designers = SetUtil.union(Utils.copy(designers), SetUtil.set(designer));
  }

  public void removeDesigner(final Designer designer) {

    designers = SetUtil.diff(Utils.copy(designers), SetUtil.set(designer));
  }

  public Platform() {}

  public String toString() {

    return "Platform{"
        + "actualDate := "
        + Utils.toString(actualDate)
        + ", users := "
        + Utils.toString(users)
        + ", events := "
        + Utils.toString(events)
        + ", items := "
        + Utils.toString(items)
        + ", designers := "
        + Utils.toString(designers)
        + "}";
  }

  public static class Date implements Record {
    public Number year;
    public Number month;
    public Number day;

    public Date(final Number _year, final Number _month, final Number _day) {

      year = _year;
      month = _month;
      day = _day;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day);
    }

    public Date copy() {

      return new Date(year, month, day);
    }

    public String toString() {

      return "mk_Platform`Date" + Utils.formatFields(year, month, day);
    }
  }

  public static Boolean inv_Date(final Date d) {

    Boolean andResult_17 = false;

    if (d.month.longValue() <= 12L) {
      if (d.day.longValue() <= 30L) {
        andResult_17 = true;
      }
    }

    return andResult_17;
  }
}
