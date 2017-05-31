import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue example
 * @author former ICS4U students
 *
 */
public class QueueExample {

    public static void main(String[] args) {

    	// Create Queue and add content
        Queue<String> qe=new LinkedList<String>();
        qe.add("a");
        qe.add("b");
        qe.add("c");
        qe.add("d");
        qe.add("e");
      
        System.out.println("Initial Size of Queue :"+qe.size());

        System.out.println(qe.remove());
        System.out.println(qe.remove());
        System.out.println(qe.remove());

        System.out.println("Size of Queue :"+qe.size());
        
        qe.add("f");
        qe.add("g");
        qe.add("h");

        System.out.println("Size of Queue :"+qe.size());
        
        // get value and does not remove element from queue
        System.out.println("Queue peek :"+qe.peek());

        // get first value and remove that object from queue
        System.out.println("Queue poll :"+qe.remove());
        
        System.out.println("Queue peek :"+qe.peek());

        System.out.println("Final Size of Queue :"+qe.size());
    }
}