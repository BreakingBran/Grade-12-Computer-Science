import java.util.*;

public class NextInLine
{
  public static void main(String args[]) 
  {
    Scanner sc = new Scanner(System.in);

    int youngest = sc.nextInt();
    int middle = sc.nextInt();
    System.out.println(middle + (middle-youngest));
  }
}
