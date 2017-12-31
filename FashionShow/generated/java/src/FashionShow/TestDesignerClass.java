package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestDesignerClass extends MyTestCase {
  private Item it1 =
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.XLQuote.getInstance());
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
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.XSQuote.getInstance());
  private Item it6 =
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.XSQuote.getInstance());
  private Item it7 =
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.SQuote.getInstance());
  private Item it8 =
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.MQuote.getInstance());
  private Model m1 =
      new Model(
          "Adriana Lima", 36L, 1.78, "Brasilian", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m2 =
      new Model(
          "Sara Sampaio", 26L, 1.72, "Portuguese", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m3 =
      new Model(
          "Karlie Kloss", 25L, 1.88, "American", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m4 =
      new Model("Gigi Hadid", 22L, 1.79, "American", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m5 =
      new Model(
          "Candice Swanepoel", 29L, 1.77, "African", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m6 =
      new Model(
          "Lily Aldridge", 32L, 1.75, "American", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m7 =
      new Model(
          "Ashley Graham", 30L, 1.75, "American", FashionShow.quotes.FemaleQuote.getInstance());
  private Model m8 =
      new Model(
          "Miles McMillan", 28L, 1.88, "American", FashionShow.quotes.MaleQuote.getInstance());

  public void testAddItem() {

    IO.println("\t (1) Adição de um item a um designer");
    {
      final Designer d1 = new Designer("Coco Chanel");
      {
        d1.setItems(SetUtil.set(it1, it2, it3));
        assertEqual(d1.items, SetUtil.set(it1, it2, it3));
        d1.addItem(it4);
        assertEqual(d1.items, SetUtil.set(it1, it2, it3, it4));
      }
    }
  }

  public void testAddItems() {

    IO.println("\t (2) Adição de um conjunto de items a um designer");
    {
      final Designer d1 = new Designer("Coco Chanel");
      {
        d1.setItems(SetUtil.set(it1));
        assertEqual(d1.items, SetUtil.set(it1));
        d1.addItems(SetUtil.set(it4, it2, it3, it5));
        assertEqual(d1.items, SetUtil.set(it1, it4, it2, it3, it5));
        d1.addItems(SetUtil.set(it2, it3, it6));
        assertEqual(d1.items, SetUtil.set(it1, it4, it2, it3, it5, it6));
      }
    }
  }

  public void testRemItem() {

    IO.println("\t (4) Remoção de um item de um designer");
    {
      final Designer d1 = new Designer("Coco Chanel");
      {
        d1.setItems(SetUtil.set(it1, it2, it3));
        assertEqual(d1.items, SetUtil.set(it1, it2, it3));
        d1.remItem(it3);
        assertEqual(d1.items, SetUtil.set(it1, it2));
      }
    }
  }

  public void testRemItems() {

    IO.println("\t (3) Remoção de um conjunto de items de um designer");
    {
      final Designer d1 = new Designer("Coco Chanel");
      {
        d1.setItems(SetUtil.set(it1, it2, it3));
        assertEqual(d1.items, SetUtil.set(it1, it2, it3));
        d1.remItems(SetUtil.set(it2, it3));
        assertEqual(d1.items, SetUtil.set(it1));
      }
    }
  }

  public void testAll() {

    IO.println("Testes da classe Designer:");
    testAddItem();
    testAddItems();
    testRemItems();
    testRemItem();
  }

  public TestDesignerClass() {}

  public String toString() {

    return "TestDesignerClass{"
        + "it1 := "
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
        + "}";
  }
}
