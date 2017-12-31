package FashionShow;

import java.io.Serializable;
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Item implements Serializable{
  public String name;
  public String reference;
  public Number price;
  public Object size;

  public void cg_init_Item_1(final String n, final String r, final Number p, final Object s) {

    name = n;
    reference = r;
    price = p;
    size = s;
    return;
  }

  public Item(final String n, final String r, final Number p, final Object s) {

    cg_init_Item_1(n, r, p, s);
  }

  public Item() {}

  public String toString() {

    return "Item{"
        + "name := "
        + Utils.toString(name)
        + ", reference := "
        + Utils.toString(reference)
        + ", price := "
        + Utils.toString(price)
        + ", size := "
        + Utils.toString(size)
        + "}";
  }
}
