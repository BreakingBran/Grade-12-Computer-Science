import static org.junit.Assert.*;
import java.io.*;
import org.junit.Test;


public class RovarspraketTest {

  @Test
  public  void test() {
    String lowercaseInput = "abcdefghijklmnopqrstuvwxyz";
    String loewrcase = "abaccaddefefeggehhijijikkillimmonnopopoqqorrossuttuvuvuwwuxxuyyuzzuz";
    String uppercaseInput = lowercaseInput.toUpperCase();
    assertEquals(Rovarspraket.getOutput("a"),"a");
    assertEquals(Rovarspraket.getOutput("b"),"bac");
    assertEquals(Rovarspraket.getOutput(lowercaseInput),loewrcase);
    assertEquals(Rovarspraket.getOutput(uppercaseInput),loewrcase);
    assertEquals(Rovarspraket.getOutput("A"),"a");
    assertEquals(Rovarspraket.getOutput("AAA"),"aaa");
    //assertEquals(Rovarspraket.getOutput("a"),"a");

  }

}
