
import java.util.HashSet;
public class LinkedList
{
    Node head;
    
    static class Node{
        Node next = null;
        int data;
        Node(int d){
            next = null;
            data = d;
        }
    }
    public static LinkedList insert(LinkedList list, int d){
        Node new_node = new Node(d);
        new_node.next = null;
        if(list.head == null){
            list.head = new_node;
            System.out.println("hello");
            return list;
        }
        Node last= list.head;
        while(last.next != null){
            last = last.next;
        }
        last.next = new_node;
        return list;
    }
    public static void printlist(LinkedList list){
        Node current = list.head;
        System.out.print("Printing LinkedList:");
        while(current!=null){
            System.out.print(" "+current.data);
            current = current.next;
        }
        System.out.println();
    }
    public static LinkedList dup(LinkedList list){
        Node current=list.head;
        while(current !=null){
            Node runner = current;
            while(runner.next != null){
                if(current.data == runner.next.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
                
            }
            current =  current.next;
        }
        return list;
    }
    public static LinkedList deleteduplicate(LinkedList list){
        HashSet<Integer> set = new HashSet<Integer>();
        Node prev = null;
        Node current = list.head;
        while(current !=null){
            if(set.contains(current.data)){
                prev.next = current.next;
            }else{
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }
        return list;
    }
    public static int ktolast(LinkedList list, int k){
        Node n = list.head;
        if(n == null){
            return 0;
        }
        list.head = n.next;
        int index = ktolast(list,k) + 1;
        
        if(k == index){
            System.out.println("Value = "+n.data);
            
        }
        return index;
    }
   public static LinkedList partition(LinkedList list, int x) {
	   Node bfirst = null;
	   Node blast = null;
	   Node afirst = null;
	   Node alast = null;
	   Node n = list.head;

	   while(n != null) {
		   Node new_node = n.next;
		   n.next = null;
		   
		   if(n.data < x) {
			   if(bfirst == null) {
				   bfirst = n;
				   blast = bfirst;
			   }else {
				  
				   blast.next = n;
				   blast = blast.next;
			   }
		   }else {
			   
				   if(afirst == null) {
					   afirst = n;
					   alast = afirst;
				   }else {
					   alast.next = n;
					   alast = alast.next;
				   }
		   }
		   n = new_node;
		   
	   }
	   if(afirst == null) {
		   list.head = afirst;
		   return list;
	   }
	   blast.next = afirst;
	   list.head = bfirst;
	   return list;
   }
	public static void main(String[] args) {
    	LinkedList list = new LinkedList();
		
		list = insert(list,2);
		list = insert(list,8);
		list = insert(list,3);
		list = insert(list,6);
		list = insert(list,2);
		list = insert(list,9);
		list = insert(list,3);
		list = insert(list,4);
		list = insert(list,8);
		list = insert(list,5);
		list = insert(list,7);
		list = insert(list,1);
		
		
		printlist(list);
		list = deleteduplicate(list);
		printlist(list);
		//System.out.println(" k ="+(ktolast(list,4)-4) ); // this will change the list.head
		list = partition(list,5);
		printlist(list);
		
	}
}
