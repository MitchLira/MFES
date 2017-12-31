package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model {
  public String name;
  public Number age;
  public Number height;
  public String nationality;
  public VDMSet shows;
  public Object gender;

  public void cg_init_Model_1(
      final String n, final Number a, final Number h, final String na, final Object g) {

    name = n;
    age = a;
    height = h;
    nationality = na;
    shows = SetUtil.set();
    gender = g;
    return;
  }

  public Model(final String n, final Number a, final Number h, final String na, final Object g) {

    cg_init_Model_1(n, a, h, na, g);
  }

  public void setShows(final VDMSet newShows) {

    shows = Utils.copy(newShows);
  }

  public void addShow(final Event newShow) {

    shows = SetUtil.union(Utils.copy(shows), SetUtil.set(newShow));
  }

  public void remShow(final Event oldShow) {

    shows = SetUtil.diff(Utils.copy(shows), SetUtil.set(oldShow));
  }

  public Model() {}

  public String toString() {

    return "Model{"
        + "name := "
        + Utils.toString(name)
        + ", age := "
        + Utils.toString(age)
        + ", height := "
        + Utils.toString(height)
        + ", nationality := "
        + Utils.toString(nationality)
        + ", shows := "
        + Utils.toString(shows)
        + ", gender := "
        + Utils.toString(gender)
        + "}";
  }
}
