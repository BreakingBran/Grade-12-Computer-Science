import java.util.*;

public class NextInLine
{
  public static void main(String args[]) 
  {
    //takes in middle and youngest age
    //finds diffirence between two, adds to middle
    // outputs above result
    
    Scanner sc = new Scanner(System.in);

    int youngest = sc.nextInt();
    int middle = sc.nextInt();
    
    //outpults oldest age
    System.out.println(middle + (middle-youngest));
  }
}
