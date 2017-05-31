
import java.util.Stack;

import java.util.Scanner;

/**
 * Stack demo
 * @author former 4U students
 *
 */
public class StackDemonstration 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        Stack demo = new Stack();
        String run = "";

        while(!(run.equals("end")))
        {
            System.out.println("What do you want to do?(push, pop, peek, empty, print, end): ");
            run = sc.next();

            if(run.equals("push"))
            {
                System.out.print("Type what to add to the stack");
                String data = sc.next();
                demo.push(data);
            }
            else if(run.equals("peek"))
            {
                System.out.println(demo.peek()+" is at the top of the stack.");
            }
            else if(run.equals("empty"))
            {
                boolean result = demo.empty();
                if(result == false)
                {
                    System.out.println(result + ", The stack is not empty");
                }
                else
                {
                    System.out.println(result + ", The stack is empty");
                }
            }
            else if(run.equals("pop"))
            {
                System.out.println("how many do you want to remove?");
                int pops = sc.nextInt();
                for(int i= 0; i < pops;i++)
                {	
                	System.out.println("Popped out "+demo.pop());
                }                
            }
            else if(run.equals("print"))
            {
                System.out.println(demo);
            }
            else if(run.equals("end"))
            {
                System.out.println("Program has been terminated");
            }
            else
            {
                System.out.println("invalid option");
            }
        }
    }
}



