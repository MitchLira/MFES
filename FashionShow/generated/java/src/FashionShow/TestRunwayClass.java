package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestRunwayClass extends MyTestCase {
  private Runway f1 =
      new Runway("Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
  private Runway f2 =
      new Runway("New World", new Platform.Date(2019L, 11L, 10L), "U.S.A", "Rock", 100L, 60L);
  private Runway f3 =
      new Runway("Pop Culture", new Platform.Date(2018L, 8L, 2L), "Paris", "Pop", 20L, 90L);
  private Designer d1 = new Designer("Miguel Lira");
  private Designer d2 = new Designer("Miriam GonÃ§alves");
  private Designer d3 = new Designer("Paulo SÃ©rgio");
  private Designer d4 = new Designer("Coco Chanel");
  private Designer d5 = new Designer("Ralph Lauren");
  private Model m1 =
      new Model("Adriana Lima", 36L, 1.78, "Brasil", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m2 =
      new Model(
          "Sara Sampaio", 26L, 1.72, "Portugal", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m3 =
      new Model("Karlie Kloss", 25L, 1.88, "U.S.A", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m4 =
      new Model("Gigi Hadid", 22L, 1.79, "U.S.A", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m5 =
      new Model(
          "Candice Swanepoel",
          29L,
          1.77,
          "Africa do Sul",
          FashionShow.quotes.FemaleQuote.getInstance());
  private Model m6 =
      new Model("Lily Aldridge", 32L, 1.75, "U.S.A", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m7 =
      new Model("Ashley Graham", 30L, 1.75, "U.S.A", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m8 =
      new Model("Miles McMillan", 28L, 1.88, "U.S.A", FashionShow.quotes.MaleQuote.getInstance());
  private Item it1 =
      new Item("Camisolinha de lÃ£", "1c34ff445", 220.5, FashionShow.quotes.XLQuote.getInstance());
  private Item it2 =
      new Item("Oculos de Sol Gucci", "123ggg4hk", 220.5, FashionShow.quotes.SQuote.getInstance());
  private Item it3 =
      new Item("Calcinha Branca", "1c34ff445", 220.5, FashionShow.quotes.MQuote.getInstance());
  private Item it4 =
      new Item(
          "Camisola Sarja Preta Versace",
          "3213fff23",
          220.5,
          FashionShow.quotes.LQuote.getInstance());
  private Item it5 =
      new Item("Camisolinha de lÃ£", "1c34ff445", 220.5, FashionShow.quotes.SQuote.getInstance());
  private Item it6 =
      new Item("Blusa axadrezada", "1c34ff345", 203L, FashionShow.quotes.XSQuote.getInstance());
  private Item it7 =
      new Item("CalÃ§as rasgadas", "2c34ff445", 220L, FashionShow.quotes.SQuote.getInstance());
  private Item it8 =
      new Item("Camisa Rosa", "1c32ff445", 120L, FashionShow.quotes.MQuote.getInstance());

  public void testRunwayAttributes() {

    IO.println("\t (1) Construtor de um Runway");
    assertEqual(f1.name, "Wonderland");
    assertEqual(f1.date, new Platform.Date(2018L, 9L, 20L));
    assertEqual(f1.place, "London");
    assertEqual(f1.theme, "Fantasy");
    assertEqual(f1.price, 75L);
    assertEqual(f1.maxSpectators, 100L);
  }

  public void testAddModel() {

    IO.println("\t (2) Adição de uma modelo a um desfile");
    f1.setModels(SetUtil.set(m1, m2, m3));
    assertEqual(f1.models, SetUtil.set(m1, m2, m3));
    f1.addModel(m4);
    assertEqual(f1.models, SetUtil.set(m1, m2, m3, m4));
  }

  public void testAddModels() {

    IO.println("\t (3) Adição de um conjunto de modelos a um desfile");
    {
      final Runway d1_1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d1_1.setModels(SetUtil.set(m1));
        assertEqual(d1_1.models, SetUtil.set(m1));
        d1_1.addModels(SetUtil.set(m4, m2, m3, m5));
        assertEqual(d1_1.models, SetUtil.set(m1, m4, m2, m3, m5));
        d1_1.addModels(SetUtil.set(m2, m3, m6));
        assertEqual(d1_1.models, SetUtil.set(m1, m4, m2, m3, m5, m6));
      }
    }
  }

  public void testRemModel() {

    IO.println("\t (4) Remoção de uma modelo de um desfile");
    {
      final Runway d1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d1.setModels(SetUtil.set(m1, m2, m3));
        assertEqual(d1.models, SetUtil.set(m1, m2, m3));
        d1.remModel(m3);
        assertEqual(d1.models, SetUtil.set(m1, m2));
      }
    }
  }

  public void testRemModels() {

    IO.println("\t (5) Remoção de um conjunto de modelos de um desfile");
    {
      final Runway d1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d1.setModels(SetUtil.set(m1, m2, m3));
        assertEqual(d1.models, SetUtil.set(m1, m2, m3));
        d1.remModels(SetUtil.set(m2, m3));
        assertEqual(d1.models, SetUtil.set(m1));
      }
    }
  }

  public void testAddDesigner() {

    IO.println("\t (6) Adição de um designer e os seus items a um desfile");
    {
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d1.addItems(SetUtil.set(it1, it2));
        show1.addDesigner(d1);
        assertEqual(show1.designers, SetUtil.set(d1));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d1, SetUtil.set(it1, it2))));
      }
    }
  }

  public void testRemDesigner() {

    IO.println("\t (7) Remoção de um designer e dos seus items de um desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5));
        show1.addDesigner(d6);
        assertEqual(show1.designers, SetUtil.set(d6));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d6, SetUtil.set(it1, it2))));
        show1.addDesigner(d7);
        assertEqual(show1.designers, SetUtil.set(d6, d7));
        assertEqual(
            show1.expositionItems,
            MapUtil.map(
                new Maplet(d6, SetUtil.set(it1, it2)), new Maplet(d7, SetUtil.set(it4, it5))));
        show1.removeDesigner(d6);
        assertEqual(show1.designers, SetUtil.set(d7));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d7, SetUtil.set(it4, it5))));
      }
    }
  }

  public void testItemsOfDesigner() {

    IO.println("\t (8) Seleção de items de um designer específico de um desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5));
        show1.addDesigner(d6);
        assertEqual(show1.designers, SetUtil.set(d6));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d6, SetUtil.set(it1, it2))));
        show1.addDesigner(d7);
        assertEqual(show1.designers, SetUtil.set(d6, d7));
        assertEqual(
            show1.expositionItems,
            MapUtil.map(
                new Maplet(d6, SetUtil.set(it1, it2)), new Maplet(d7, SetUtil.set(it4, it5))));
        assertEqual(show1.getItemsOfDesignerInShow(d6), SetUtil.set(it1, it2));
      }
    }
  }

  public void testAddDesignerItem() {

    IO.println("\t (9) Adição de um item a um designer de um desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4));
        show1.addDesigner(d6);
        assertEqual(show1.designers, SetUtil.set(d6));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d6, SetUtil.set(it1, it2))));
        show1.addDesigner(d7);
        assertEqual(show1.designers, SetUtil.set(d6, d7));
        assertEqual(
            show1.expositionItems,
            MapUtil.map(new Maplet(d6, SetUtil.set(it1, it2)), new Maplet(d7, SetUtil.set(it4))));
        assertEqual(show1.getItemsOfDesignerInShow(d6), SetUtil.set(it1, it2));
        show1.addDesignerItem(d6, it5);
        assertEqual(
            show1.expositionItems,
            MapUtil.map(
                new Maplet(d6, SetUtil.set(it1, it2, it5)), new Maplet(d7, SetUtil.set(it4))));
        assertEqual(show1.getItemsOfDesignerInShow(d6), SetUtil.set(it1, it2, it5));
      }
    }
  }

  public void testRemDesignerItem() {

    IO.println("\t (10) Remoção de um item de um designer de um desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5, it6));
        show1.addDesigner(d6);
        assertEqual(show1.designers, SetUtil.set(d6));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d6, SetUtil.set(it1, it2))));
        show1.addDesigner(d7);
        assertEqual(show1.designers, SetUtil.set(d6, d7));
        assertEqual(
            show1.expositionItems,
            MapUtil.map(
                new Maplet(d6, SetUtil.set(it1, it2)), new Maplet(d7, SetUtil.set(it4, it5, it6))));
        assertEqual(show1.getItemsOfDesignerInShow(d6), SetUtil.set(it1, it2));
        show1.removeDesignerItem(d7, it5);
        assertEqual(
            show1.expositionItems,
            MapUtil.map(
                new Maplet(d6, SetUtil.set(it1, it2)), new Maplet(d7, SetUtil.set(it4, it6))));
        assertEqual(show1.getItemsOfDesignerInShow(d7), SetUtil.set(it4, it6));
      }
    }
  }

  public void testItemsInShow() {

    IO.println("\t (11) Seleção de items de um desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5, it6));
        show1.addDesigner(d6);
        assertEqual(show1.designers, SetUtil.set(d6));
        assertEqual(show1.expositionItems, MapUtil.map(new Maplet(d6, SetUtil.set(it1, it2))));
        show1.addDesigner(d7);
        assertEqual(show1.designers, SetUtil.set(d6, d7));
        assertEqual(
            show1.expositionItems,
            MapUtil.map(
                new Maplet(d6, SetUtil.set(it1, it2)), new Maplet(d7, SetUtil.set(it4, it5, it6))));
        assertEqual(show1.getItemsOfDesignerInShow(d6), SetUtil.set(it1, it2));
        assertEqual(show1.getItemsInShow(), SetUtil.set(it1, it2, it4, it5, it6));
      }
    }
  }

  public void testSetModelItem() {

    IO.println("\t (12) Adicionar um item a uma modelo num desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5, it6));
        show1.addDesigner(d6);
        show1.addModels(SetUtil.set(m1, m2));
        show1.addDesigner(d7);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set()), new Maplet(m2, SetUtil.set())));
        show1.setModelItem(m1, it1);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set(it1)), new Maplet(m2, SetUtil.set())));
        show1.setModelItem(m2, it6);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set(it1)), new Maplet(m2, SetUtil.set(it6))));
      }
    }
  }

  public void testSetModelOutfit() {

    IO.println("\t (13) Adição de um conjunto de items a uma modelo de um desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5, it6));
        show1.addDesigner(d6);
        show1.addModels(SetUtil.set(m1, m2));
        show1.addDesigner(d7);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set()), new Maplet(m2, SetUtil.set())));
        show1.setModelOutfit(m1, SetUtil.set(it1, it5));
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set(it1, it5)), new Maplet(m2, SetUtil.set())));
        show1.setModelOutfit(m2, SetUtil.set(it6, it2, it4));
        assertEqual(
            show1.modelsItems,
            MapUtil.map(
                new Maplet(m1, SetUtil.set(it1, it5)), new Maplet(m2, SetUtil.set(it6, it2, it4))));
      }
    }
  }

  public void testRemModelOutfit() {

    IO.println("\t (14) Remoção de um conjunto de items de uma modelo num desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        d6.addItems(SetUtil.set(it1, it2));
        d7.addItems(SetUtil.set(it4, it5, it6));
        show1.addDesigner(d6);
        show1.addModels(SetUtil.set(m1, m2));
        show1.addDesigner(d7);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set()), new Maplet(m2, SetUtil.set())));
        show1.setModelOutfit(m1, SetUtil.set(it1, it5));
        show1.setModelOutfit(m2, SetUtil.set(it6, it2, it4));
        assertEqual(
            show1.modelsItems,
            MapUtil.map(
                new Maplet(m1, SetUtil.set(it1, it5)), new Maplet(m2, SetUtil.set(it6, it2, it4))));
        show1.removeModelOutfit(m1);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set()), new Maplet(m2, SetUtil.set(it6, it2, it4))));
        show1.removeModelOutfit(m2);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set()), new Maplet(m2, SetUtil.set())));
      }
    }
  }

  public void testRemModelItem() {

    IO.println("\t (15) Remoção de um item de uma modelo num desfile");
    {
      final Designer d6 = new Designer("Karl Lagerfeld");
      final Designer d7 = new Designer("Donatella Versace");
      final Runway show1 =
          new Runway(
              "Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
      {
        show1.addDesigner(d6);
        show1.addModels(SetUtil.set(m1, m2));
        show1.addDesigner(d7);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(new Maplet(m1, SetUtil.set()), new Maplet(m2, SetUtil.set())));
        show1.setModelOutfit(m1, SetUtil.set(it1, it5));
        show1.setModelOutfit(m2, SetUtil.set(it6, it2, it4));
        assertEqual(
            show1.modelsItems,
            MapUtil.map(
                new Maplet(m1, SetUtil.set(it1, it5)), new Maplet(m2, SetUtil.set(it6, it2, it4))));
        show1.removeModelItem(m1, it1);
        assertEqual(
            show1.modelsItems,
            MapUtil.map(
                new Maplet(m1, SetUtil.set(it5)), new Maplet(m2, SetUtil.set(it6, it2, it4))));
      }
    }
  }

  public void testAll() {

    IO.println("Testes da classe Runway:");
    testRunwayAttributes();
    testAddModel();
    testAddModels();
    testRemModel();
    testRemModels();
    testAddDesigner();
    testRemDesigner();
    testItemsOfDesigner();
    testAddDesignerItem();
    testRemDesignerItem();
    testItemsInShow();
    testSetModelItem();
    testSetModelOutfit();
    testRemModelOutfit();
    testRemModelItem();
  }

  public TestRunwayClass() {}

  public String toString() {

    return "TestRunwayClass{"
        + "f1 := "
        + Utils.toString(f1)
        + ", f2 := "
        + Utils.toString(f2)
        + ", f3 := "
        + Utils.toString(f3)
        + ", d1 := "
        + Utils.toString(d1)
        + ", d2 := "
        + Utils.toString(d2)
        + ", d3 := "
        + Utils.toString(d3)
        + ", d4 := "
        + Utils.toString(d4)
        + ", d5 := "
        + Utils.toString(d5)
        + ", m1 := "
        + Utils.toString(m1)
        + ", m2 := "
        + Utils.toString(m2)
        + ", m3 := "
        + Utils.toString(m3)
        + ", m4 := "
        + Utils.toString(m4)
        + ", m5 := "
        + Utils.toString(m5)
        + ", m6 := "
        + Utils.toString(m6)
        + ", m7 := "
        + Utils.toString(m7)
        + ", m8 := "
        + Utils.toString(m8)
        + ", it1 := "
        + Utils.toString(it1)
        + ", it2 := "
        + Utils.toString(it2)
        + ", it3 := "
        + Utils.toString(it3)
        + ", it4 := "
        + Utils.toString(it4)
        + ", it5 := "
        + Utils.toString(it5)
        + ", it6 := "
        + Utils.toString(it6)
        + ", it7 := "
        + Utils.toString(it7)
        + ", it8 := "
        + Utils.toString(it8)
        + "}";
  }
}
