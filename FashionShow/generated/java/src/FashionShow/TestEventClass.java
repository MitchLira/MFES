package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestEventClass extends MyTestCase {
  private Event ev1 =
      new Event("Workshop Liner", new Platform.Date(2018L, 1L, 12L), "Porto", "MakeUp", 10L, 15L);
  private Designer d1 = new Designer("Oscar de La Renta");
  private Designer d2 = new Designer("Donna Karen");
  private User u1 = new User("pBabo", "Paulo Babo");
  private User u2 = new User("mitchlira", "Miguel Lira");

  public void testUsers() {

    IO.println("\t (1) Registar um User num Evento");
    u1.setBudget(100L);
    ev1.registerUser(u1);
    assertEqual(1L, ev1.audience.size());
    IO.println("\t (2) Verificação do Budget de um User após Registo num Evento");
    assertEqual(90L, u1.budget);
    IO.println("\t (3) Remoção de um User de um Evento");
    ev1.refundUser(u1);
    assertEqual(0L, ev1.audience.size());
    IO.println("\t (4) Verificação da reposição do Budget do User removido do Evento");
    assertEqual(100L, u1.budget);
    IO.println("\t (5) Adicionar Designers ao Evento");
    ev1.registerUser(u1);
    u2.setBudget(222L);
    ev1.registerUser(u2);
    assertEqual(2L, ev1.audience.size());
    ev1.addDesigner(d1);
    ev1.addDesigner(d2);
    assertEqual(2L, ev1.designers.size());
    IO.println("\t (6) Remoção de um Designer a um Evento");
    ev1.removeDesigner(d1);
    assertEqual(1L, ev1.designers.size());
    for (Iterator iterator_16 = ev1.designers.iterator(); iterator_16.hasNext(); ) {
      Designer designer = (Designer) iterator_16.next();
      assertEqual("Donna Karen", designer.name);
    }
  }

  public void testAll() {

    IO.println("Testes da classe Event:");
    testUsers();
  }

  public TestEventClass() {}

  public String toString() {

    return "TestEventClass{"
        + "ev1 := "
        + Utils.toString(ev1)
        + ", d1 := "
        + Utils.toString(d1)
        + ", d2 := "
        + Utils.toString(d2)
        + ", u1 := "
        + Utils.toString(u1)
        + ", u2 := "
        + Utils.toString(u2)
        + "}";
  }
}
