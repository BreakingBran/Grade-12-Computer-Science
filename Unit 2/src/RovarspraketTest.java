import static org.junit.Assert.*;

import org.junit.Test;


public class RovarspraketTest {

  @Test
  public  void test() {
    String loewrcase = "abaccaddefefeggehhijijikkillimmonnopopoqqorrossuttuvuvuwwuxxuyyuzzuz";
    assertEquals(Rovarspraket.getOutput("a"),"a");
    assertEquals(Rovarspraket.getOutput("b"),"bac");
    assertEquals(Rovarspraket.getOutput("abcdefghijklmnopqrstuvwxyz"),loewrcase);
  }

}
