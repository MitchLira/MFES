package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestPlatformClass extends MyTestCase {
  private Designer d1 = new Designer("Oscar de La Renta");
  private Designer d2 = new Designer("Donna Karen");
  private Designer d3 = new Designer("Alexander McQueen");
  private Item it1 =
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.XLQuote.getInstance());
  private Item it2 =
      new Item("Oculos de Sol Gucci", "123ggg4hk", 220.5, FashionShow.quotes.SQuote.getInstance());
  private Item it3 =
      new Item("Calcinha Branca", "1c34ff445", 220.5, FashionShow.quotes.MQuote.getInstance());
  private User u1 = new User("mitchLira", "Miguel Lira");
  private User u2 = new User("miriniri", "Miriam Goncalves");
  private User u3 = new User("pauloB", "Paulo Babo");
  private Event e1 =
      new PrimpingSession(
          "Fique Bela e Amarela",
          new Platform.Date(2017L, 12L, 29L),
          "Avenida dos Aliados",
          "Amarelo/Dourado",
          20L,
          50L);
  private Event e2 =
      new Presentation(
          "Como andar na moda?",
          new Platform.Date(2018L, 1L, 5L),
          "Antigas Fabricas Tabopan",
          "Moda",
          5L,
          300L);
  private Event e3 =
      new Runway(
          "Victoria's Secret Runway",
          new Platform.Date(2018L, 2L, 22L),
          "Covelo de Ansiães",
          "Langerie",
          300L,
          50L);
  private Event e4 =
      new Runway(
          "Gigi vs Tommy Runway",
          new Platform.Date(2018L, 12L, 30L),
          "Amarante",
          "Funny",
          300L,
          50L);
  private Event e5 =
      new Runway(
          "Gucci for poor", new Platform.Date(2019L, 11L, 30L), "Guimarães", "Pobreza", 300L, 50L);
  private Platform p1 = new Platform(new Platform.Date(2017L, 12L, 29L));
  private Platform p2 = new Platform(new Platform.Date(2018L, 12L, 30L));
  private Platform p3 = new Platform(new Platform.Date(2017L, 11L, 30L));

  public void testAddRemoveDesigner() {

    IO.println("\t (1) Adição e remoção de um designer da plataforma");
    p1.addDesigner(d1);
    p1.addDesigner(d2);
    assertEqual(SetUtil.set(d1, d2), p1.designers);
    p1.removeDesigner(d2);
    assertEqual(SetUtil.set(d1), p1.designers);
  }

  public void testAddRemoveItem() {

    IO.println("\t (2) Adição e remoção de um item da plataforma");
    p1.addItem(it1);
    p1.addItem(it2);
    assertEqual(SetUtil.set(it1, it2), p1.items);
    p1.removeItem(it2);
    p1.removeItem(it1);
    assertEqual(SetUtil.set(), p1.items);
  }

  public void testAddRemoveUser() {

    IO.println("\t (3) Adição e remoção de um utilizador da plataforma");
    p1.addUser(u1);
    p1.addUser(u2);
    assertEqual(SetUtil.set(u1, u2), p1.users);
    p1.removeUser(u2);
    p1.removeUser(u1);
    assertEqual(SetUtil.set(), p1.users);
  }

  public void testAddRemoveEvent() {

    IO.println("\t (4) Adição e remoção de um evento da plataforma");
    p1.addEvent(e1);
    p1.addEvent(e2);
    assertEqual(SetUtil.set(e1, e2), p1.events);
    p1.removeEvent(e2);
    p1.removeEvent(e1);
    assertEqual(SetUtil.set(), p1.events);
  }

  public void testEndDay() {

    IO.println("\t (5) Finalização de um dia de eventos");
    p1.addEvent(e1);
    p1.addEvent(e2);
    p1.endDay();
    assertEqual(30L, p1.actualDate.day);
    assertEqual(12L, p1.actualDate.month);
    assertEqual(2017L, p1.actualDate.year);
    assertEqual(SetUtil.set(e2), p1.events);
    p2.addEvent(e4);
    p2.endDay();
    assertEqual(1L, p2.actualDate.day);
    assertEqual(1L, p2.actualDate.month);
    assertEqual(2019L, p2.actualDate.year);
    p1.removeEvent(e2);
    p3.addEvent(e5);
    p3.endDay();
    assertEqual(1L, p3.actualDate.day);
    assertEqual(12L, p3.actualDate.month);
    assertEqual(2017L, p3.actualDate.year);
  }

  public void testAll() {

    IO.println("Testes da classe Platform:");
    testAddRemoveDesigner();
    testAddRemoveUser();
    testAddRemoveItem();
    testAddRemoveEvent();
    testEndDay();
  }

  public TestPlatformClass() {}

  public String toString() {

    return "TestPlatformClass{"
        + "d1 := "
        + Utils.toString(d1)
        + ", d2 := "
        + Utils.toString(d2)
        + ", d3 := "
        + Utils.toString(d3)
        + ", it1 := "
        + Utils.toString(it1)
        + ", it2 := "
        + Utils.toString(it2)
        + ", it3 := "
        + Utils.toString(it3)
        + ", u1 := "
        + Utils.toString(u1)
        + ", u2 := "
        + Utils.toString(u2)
        + ", u3 := "
        + Utils.toString(u3)
        + ", e1 := "
        + Utils.toString(e1)
        + ", e2 := "
        + Utils.toString(e2)
        + ", e3 := "
        + Utils.toString(e3)
        + ", e4 := "
        + Utils.toString(e4)
        + ", e5 := "
        + Utils.toString(e5)
        + ", p1 := "
        + Utils.toString(p1)
        + ", p2 := "
        + Utils.toString(p2)
        + ", p3 := "
        + Utils.toString(p3)
        + "}";
  }
}
