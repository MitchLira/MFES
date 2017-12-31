package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestPresentationClass extends MyTestCase {
  private Presentation p1 =
      new Presentation(
          "New Versace Collection",
          new Platform.Date(2018L, 12L, 30L),
          "Lisbon",
          "Spring",
          120L,
          50L);

  public void testPresentationAttributes() {

    IO.println("\t (1) Construtor de uma Presentation");
    assertEqual(p1.name, "New Versace Collection");
    assertEqual(p1.place, "Lisbon");
    assertEqual(p1.theme, "Spring");
    assertEqual(p1.date, new Platform.Date(2018L, 12L, 30L));
    assertEqual(p1.price, 120L);
    assertEqual(p1.maxSpectators, 50L);
  }

  public void testAll() {

    IO.println("Testes da classe Presentation:");
    testPresentationAttributes();
  }

  public TestPresentationClass() {}

  public String toString() {

    return "TestPresentationClass{" + "p1 := " + Utils.toString(p1) + "}";
  }
}
