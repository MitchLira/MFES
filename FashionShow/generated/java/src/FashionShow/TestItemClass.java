package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestItemClass extends MyTestCase {
  public void testGetItemAttributes() {

    IO.println("\t (1) Construção de um Item");
    {
      final Item it1 =
          new Item("Gucci Sunglasses", "123ggg4hk", 220.5, FashionShow.quotes.SQuote.getInstance());
      {
        assertEqual(it1.name, "Gucci Sunglasses");
        assertEqual(it1.reference, "123ggg4hk");
        assertEqual(it1.price, 220.5);
        assertEqual(((Object) it1.size), FashionShow.quotes.SQuote.getInstance());
      }
    }
  }

  public void testAll() {

    IO.println("Testes da classe Item:");
    testGetItemAttributes();
  }

  public TestItemClass() {}

  public String toString() {

    return "TestItemClass{}";
  }
}
