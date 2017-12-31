package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestUtilsClass extends MyTestCase {
  public void testIsAfter() {

    IO.println("\t (1) Verifição de uma data ser posterior a outra");
    assertEqual(
        true, cg_Utils.isAfter(new Platform.Date(2017L, 2L, 3L), new Platform.Date(2017L, 2L, 2L)));
    assertEqual(
        false, cg_Utils.isAfter(new Platform.Date(2017L, 2L, 3L), new Platform.Date(2017L, 2L, 3L)));
    assertEqual(
        false, cg_Utils.isAfter(new Platform.Date(2014L, 2L, 3L), new Platform.Date(2017L, 2L, 2L)));
    assertEqual(
        true, cg_Utils.isAfter(new Platform.Date(2014L, 2L, 3L), new Platform.Date(2014L, 3L, 2L)));
  }

  public void testAll() {

    IO.println("Test da classe Utils");
    testIsAfter();
  }

  public TestUtilsClass() {}

  public String toString() {

    return "TestUtilsClass{}";
  }
}
