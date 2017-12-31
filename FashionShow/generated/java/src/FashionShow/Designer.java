package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Designer {
  public String name;
  public VDMSet items;

  public void cg_init_Designer_1(final String n) {

    name = n;
    items = SetUtil.set();
    return;
  }

  public Designer(final String n) {

    cg_init_Designer_1(n);
  }

  public void setItems(final VDMSet item) {

    items = Utils.copy(item);
  }

  public void addItem(final Item item) {

    items = SetUtil.union(Utils.copy(items), SetUtil.set(item));
  }

  public void addItems(final VDMSet newItems) {

    for (Iterator iterator_8 = newItems.iterator(); iterator_8.hasNext(); ) {
      Item i = (Item) iterator_8.next();
      items = SetUtil.union(Utils.copy(items), SetUtil.set(i));
    }
  }

  public void remItem(final Item item) {

    items = SetUtil.diff(Utils.copy(items), SetUtil.set(item));
  }

  public void remItems(final VDMSet oldItems) {

    for (Iterator iterator_9 = oldItems.iterator(); iterator_9.hasNext(); ) {
      Item i = (Item) iterator_9.next();
      items = SetUtil.diff(Utils.copy(items), SetUtil.set(i));
    }
  }

  public Designer() {}

  public String toString() {

    return "Designer{"
        + "name := "
        + Utils.toString(name)
        + ", items := "
        + Utils.toString(items)
        + "}";
  }
}
