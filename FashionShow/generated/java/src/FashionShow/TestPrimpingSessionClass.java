package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestPrimpingSessionClass extends MyTestCase {
  private PrimpingSession p1 =
      new PrimpingSession(
          "Make up by Mario", new Platform.Date(2018L, 12L, 1L), "Lisbon", "MakeUp", 20L, 50L);

  public void testPrimpingAttributes() {

    IO.println("\t (1) Construtor de uma PrimpingSession ");
    assertEqual(p1.name, "Make up by Mario");
    assertEqual(p1.place, "Lisbon");
    assertEqual(p1.theme, "MakeUp");
    assertEqual(p1.date, new Platform.Date(2018L, 12L, 1L));
    assertEqual(p1.price, 20L);
    assertEqual(p1.maxSpectators, 50L);
  }

  public void testAll() {

    IO.println("Testes da classe PrimpingSession:");
    testPrimpingAttributes();
  }

  public TestPrimpingSessionClass() {}

  public String toString() {

    return "TestPrimpingSessionClass{" + "p1 := " + Utils.toString(p1) + "}";
  }
}
