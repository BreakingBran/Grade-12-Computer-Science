
public class HeapTest {

	public static void main(String arags[])
	{
		MyHeap heap = new MyHeap(); // it
		    heap.insert(8);
		    heap.insert(1);
		    heap.insert(4);
		    System.out.println("size is " + heap.getSize() + ", top is " + heap.top());
		    while(!heap.isEmpty())
		    {
		        System.out.println(heap.remove());
		    }
	}

}
