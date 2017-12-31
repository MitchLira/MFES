package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestUserClass extends MyTestCase {
  private User u3 = new User("pBabo", "Paulo Babo");
  private Item it1 =
      new Item("Camisolinha de lã", "1c34ff445", 220.5, FashionShow.quotes.XLQuote.getInstance());
  private Item it2 =
      new Item("Oculos de Sol Gucci", "123ggg4hk", 220.5, FashionShow.quotes.SQuote.getInstance());
  private Item it3 =
      new Item("Calcinha Branca", "1c34ff445", 220.5, FashionShow.quotes.MQuote.getInstance());

  public void testGetUserAttributes() {

    IO.println("\t (1) Construtor de um utilizador");
    {
      final User u4 = new User("mitchLira", "Miguel Luís");
      {
        assertEqual(u4.name, "Miguel Luís");
        assertEqual(u4.username, "mitchLira");
        assertEqual(u4.budget, 0.0);
        u4.setBudget(125.5);
        assertEqual(u4.budget, 125.5);
      }
    }
  }

  public void testSetGetBoughtItems() {

    IO.println("\t (2) Alteração de items comprados de um utilizador");
    assertEqual(SetUtil.set(), u3.getBoughtItems());
    u3.setBoughtItem(it1);
    assertEqual(SetUtil.set(it1), u3.getBoughtItems());
    u3.setBoughtItems(SetUtil.set(it2, it3));
    assertEqual(SetUtil.set(it1, it2, it3), u3.getBoughtItems());
  }

  public void testAll() {

    IO.println("Testes da classe User:");
    testGetUserAttributes();
    testSetGetBoughtItems();
  }

  public TestUserClass() {}

  public String toString() {

    return "TestUserClass{"
        + "u3 := "
        + Utils.toString(u3)
        + ", it1 := "
        + Utils.toString(it1)
        + ", it2 := "
        + Utils.toString(it2)
        + ", it3 := "
        + Utils.toString(it3)
        + "}";
  }
}
