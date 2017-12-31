package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Runway extends Event {
  public VDMMap expositionItems = MapUtil.map();
  public VDMSet models = SetUtil.set();
  public VDMMap modelsItems = MapUtil.map();
  public VDMSet showItems = SetUtil.set();

  public void cg_init_Runway_1(
      final String n,
      final Platform.Date d,
      final String p,
      final String t,
      final Number pr,
      final Number maxS) {

    name = n;
    date = Utils.copy(d);
    price = pr;
    theme = t;
    place = p;
    maxSpectators = maxS;
    return;
  }

  public Runway(
      final String n,
      final Platform.Date d,
      final String p,
      final String t,
      final Number pr,
      final Number maxS) {

    cg_init_Runway_1(n, Utils.copy(d), p, t, pr, maxS);
  }

  public void setModels(final VDMSet model) {

    models = Utils.copy(model);
  }

  public void addModel(final Model model) {

    models = SetUtil.union(Utils.copy(models), SetUtil.set(model));
    modelsItems =
        MapUtil.munion(Utils.copy(modelsItems), MapUtil.map(new Maplet(model, SetUtil.set())));
  }

  public void addModels(final VDMSet newModels) {

    for (Iterator iterator_13 = newModels.iterator(); iterator_13.hasNext(); ) {
      Model m = (Model) iterator_13.next();
      models = SetUtil.union(Utils.copy(models), SetUtil.set(m));
      modelsItems =
          MapUtil.munion(Utils.copy(modelsItems), MapUtil.map(new Maplet(m, SetUtil.set())));
    }
  }

  public void remModel(final Model model) {

    models = SetUtil.diff(Utils.copy(models), SetUtil.set(model));
  }

  public void remModels(final VDMSet oldModels) {

    for (Iterator iterator_14 = oldModels.iterator(); iterator_14.hasNext(); ) {
      Model model = (Model) iterator_14.next();
      models = SetUtil.diff(Utils.copy(models), SetUtil.set(model));
    }
  }

  public VDMSet getItemsOfDesignerInShow(final Designer designer) {

    return Utils.copy(((VDMSet) Utils.get(expositionItems, designer)));
  }

  public VDMSet getItemsInShow() {

    VDMSet items = SetUtil.set();
    for (Iterator iterator_15 = MapUtil.rng(Utils.copy(expositionItems)).iterator();
        iterator_15.hasNext();
        ) {
      VDMSet item = (VDMSet) iterator_15.next();
      items = SetUtil.union(Utils.copy(items), Utils.copy(item));
    }
    showItems = Utils.copy(items);
    return Utils.copy(items);
  }

  public void addDesigner(final Designer designer) {

    designers = SetUtil.union(Utils.copy(designers), SetUtil.set(designer));
    showItems = SetUtil.union(Utils.copy(showItems), designer.items);
    expositionItems =
        MapUtil.munion(
            Utils.copy(expositionItems), MapUtil.map(new Maplet(designer, designer.items)));
  }

  public void removeDesigner(final Designer designer) {

    designers = SetUtil.diff(Utils.copy(designers), SetUtil.set(designer));
    showItems = SetUtil.diff(Utils.copy(showItems), designer.items);
    expositionItems = MapUtil.domResBy(SetUtil.set(designer), Utils.copy(expositionItems));
  }

  public void addDesignerItem(final Designer designer, final Item item) {

    showItems = SetUtil.union(Utils.copy(showItems), SetUtil.set(item));
    Utils.mapSeqUpdate(
        expositionItems,
        designer,
        SetUtil.union(
            Utils.copy(((VDMSet) Utils.get(expositionItems, designer))), SetUtil.set(item)));
  }

  public void removeDesignerItem(final Designer designer, final Item item) {

    showItems = SetUtil.diff(Utils.copy(showItems), SetUtil.set(item));
    Utils.mapSeqUpdate(
        expositionItems,
        designer,
        SetUtil.diff(
            Utils.copy(((VDMSet) Utils.get(expositionItems, designer))), SetUtil.set(item)));
  }

  public void setModelItem(final Model model, final Item item) {

    Utils.mapSeqUpdate(
        modelsItems,
        model,
        SetUtil.union(Utils.copy(((VDMSet) Utils.get(modelsItems, model))), SetUtil.set(item)));
  }

  public void setModelOutfit(final Model model, final VDMSet items) {

    Utils.mapSeqUpdate(
        modelsItems,
        model,
        SetUtil.union(Utils.copy(((VDMSet) Utils.get(modelsItems, model))), Utils.copy(items)));
  }

  public void removeModelOutfit(final Model model) {

    modelsItems = MapUtil.domResBy(SetUtil.set(model), Utils.copy(modelsItems));
    modelsItems =
        MapUtil.munion(Utils.copy(modelsItems), MapUtil.map(new Maplet(model, SetUtil.set())));
  }

  public void removeModelItem(final Model model, final Item item) {

    Utils.mapSeqUpdate(
        modelsItems,
        model,
        SetUtil.diff(Utils.copy(((VDMSet) Utils.get(modelsItems, model))), SetUtil.set(item)));
  }

  public Runway() {}

  public String toString() {

    return "Runway{"
        + "expositionItems := "
        + Utils.toString(expositionItems)
        + ", models := "
        + Utils.toString(models)
        + ", modelsItems := "
        + Utils.toString(modelsItems)
        + ", showItems := "
        + Utils.toString(showItems)
        + "}";
  }
}
