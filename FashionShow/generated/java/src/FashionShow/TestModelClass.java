package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestModelClass extends MyTestCase {
  private Designer d1 = new Designer("Oscar de La Renta");
  private Designer d2 = new Designer("Donna Karen");
  private Designer d3 = new Designer("Alexander McQueen");
  private Designer d4 = new Designer("Coco Chanel");
  private Designer d5 = new Designer("Ralph Lauren");
  private Designer d6 = new Designer("Karl Lagerfeld");
  private Designer d7 = new Designer("Donatella Versace");
  private Runway f1 =
      new Runway("Wonderland", new Platform.Date(2018L, 9L, 20L), "London", "Fantasy", 75L, 100L);
  private Runway f2 =
      new Runway("New World", new Platform.Date(2019L, 11L, 10L), "U.S.A", "Rock", 100L, 60L);
  private Runway f3 =
      new Runway("Pop Culture", new Platform.Date(2018L, 8L, 2L), "Paris", "Pop", 20L, 90L);
  private Runway f4 =
      new Runway("Angels", new Platform.Date(2018L, 3L, 1L), "Paris", "Fantasy", 200L, 50L);
  private Runway f5 =
      new Runway("Wonderland", new Platform.Date(2018L, 9L, 21L), "London", "Fantasy", 120L, 40L);
  private Runway f6 =
      new Runway("Wonderland", new Platform.Date(2019L, 12L, 17L), "London", "Fantasy", 30L, 100L);
  private Runway f7 =
      new Runway("Wonderland", new Platform.Date(2020L, 12L, 17L), "London", "Fantasy", 40L, 120L);

  public void testGetModelsAttributes() {

    IO.println("\t (1) Construção de um Model");
    {
      final Model m1 =
          new Model(
              "Adriana Lima", 36L, 1.78, "Brasilian", FashionShow.quotes.FemaleQuote.getInstance());
      {
        assertEqual(m1.name, "Adriana Lima");
        assertEqual(m1.age, 36L);
        assertEqual(((Object) m1.gender), FashionShow.quotes.FemaleQuote.getInstance());
        assertEqual(m1.height, 1.78);
        assertEqual(m1.nationality, "Brasilian");
      }
    }
  }

  public void testSetShowsModels() {

    IO.println("\t (2) Alteração de um conjunto de shows de um Model");
    {
      final Model m1 =
          new Model(
              "Adriana Lima", 36L, 1.78, "Brasilian", FashionShow.quotes.FemaleQuote.getInstance());
      {
        m1.setShows(SetUtil.set(f1, f2, f3));
        assertEqual(m1.shows, SetUtil.set(f1, f2, f3));
      }
    }
  }

  public void testAddShowModels() {

    IO.println("\t (3) Adição de um show a um Model");
    {
      final Model m1 =
          new Model(
              "Adriana Lima", 36L, 1.78, "Brasilian", FashionShow.quotes.FemaleQuote.getInstance());
      {
        m1.setShows(SetUtil.set(f1, f2, f4));
        assertEqual(m1.shows, SetUtil.set(f1, f2, f4));
        m1.addShow(f5);
        assertEqual(m1.shows, SetUtil.set(f1, f2, f4, f5));
        m1.addShow(f6);
        assertEqual(m1.shows, SetUtil.set(f1, f2, f4, f5, f6));
        m1.addShow(f7);
        assertEqual(m1.shows, SetUtil.set(f1, f2, f4, f5, f6, f7));
      }
    }
  }

  public void testRemShowModels() {

    IO.println("\t (4) Remoção de um show de um Model");
    {
      final Model m1 =
          new Model(
              "Adriana Lima", 36L, 1.78, "Brasilian", FashionShow.quotes.FemaleQuote.getInstance());
      {
        m1.setShows(SetUtil.set(f1, f2, f4));
        assertEqual(m1.shows, SetUtil.set(f1, f2, f4));
        m1.remShow(f2);
        assertEqual(m1.shows, SetUtil.set(f1, f4));
      }
    }
  }

  public void testAll() {

    IO.println("Testes da classe Model:");
    testGetModelsAttributes();
    testSetShowsModels();
    testAddShowModels();
    testRemShowModels();
  }

  public TestModelClass() {}

  public String toString() {

    return "TestModelClass{"
        + "d1 := "
        + Utils.toString(d1)
        + ", d2 := "
        + Utils.toString(d2)
        + ", d3 := "
        + Utils.toString(d3)
        + ", d4 := "
        + Utils.toString(d4)
        + ", d5 := "
        + Utils.toString(d5)
        + ", d6 := "
        + Utils.toString(d6)
        + ", d7 := "
        + Utils.toString(d7)
        + ", f1 := "
        + Utils.toString(f1)
        + ", f2 := "
        + Utils.toString(f2)
        + ", f3 := "
        + Utils.toString(f3)
        + ", f4 := "
        + Utils.toString(f4)
        + ", f5 := "
        + Utils.toString(f5)
        + ", f6 := "
        + Utils.toString(f6)
        + ", f7 := "
        + Utils.toString(f7)
        + "}";
  }
}
