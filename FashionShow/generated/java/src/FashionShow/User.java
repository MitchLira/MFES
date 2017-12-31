package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  public String username;
  public String name;
  public Number budget;
  public VDMSet boughtItems;

  public void cg_init_User_1(final String u, final String n) {

    username = u;
    name = n;
    budget = 0.0;
    boughtItems = SetUtil.set();
    return;
  }

  public User(final String u, final String n) {

    cg_init_User_1(u, n);
  }

  public void setBudget(final Number bd) {

    budget = bd;
  }

  public VDMSet getBoughtItems() {

    return Utils.copy(boughtItems);
  }

  public void setBoughtItem(final Item item) {

    boughtItems = SetUtil.union(Utils.copy(boughtItems), SetUtil.set(item));
  }

  public void setBoughtItems(final VDMSet items) {

    boughtItems = SetUtil.union(Utils.copy(boughtItems), Utils.copy(items));
  }

  public User() {}

  public String toString() {

    return "User{"
        + "username := "
        + Utils.toString(username)
        + ", name := "
        + Utils.toString(name)
        + ", budget := "
        + Utils.toString(budget)
        + ", boughtItems := "
        + Utils.toString(boughtItems)
        + "}";
  }
}
