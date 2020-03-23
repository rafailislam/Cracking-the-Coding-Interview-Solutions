import java.util.*;

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
            return list;
        }
        Node last= list.head;
        while(last.next != null){
            last = last.next;
        }
        last.next = new_node;
        return list;
    }
    public static boolean printlist(LinkedList list){
    	if(list.head == null)
    	{
    		return false;
    	}
        Node current = list.head;
        System.out.print("LinkedList:");
        while(current != null){
            System.out.print(" "+current.data);
            current = current.next;
        }
        System.out.println();
        return true;
    }
   
    
   public static LinkedList addLoop(LinkedList list1) {
	   Node current = list1.head;
	   while(current.next != null) {
		   current = current.next;
	   }
	   Node temp = current;
	   for(int i =0;i < 10; i++) {
		   Node node = new Node(5+i);
		   current.next = node;
		   current = current.next;
	   }
	   if(current.next == null)
		   //System.out.println("i am null"+temp.data);
		   current.next = temp;
	   else current.next.next = temp;
	   
	   return list1;
   }
   public static Node loopDetection(LinkedList list) {
	   Node slow = list.head;
	   Node fast = list.head;
	   
	   while(fast != null && fast.next != null) {
		   slow = slow.next;
		   fast = fast.next.next;
		   if(slow == fast)
			   break;
	   }
	   if(fast == null || fast.next == null)
		   return null;
	   
	   slow = list.head;
	   while(slow != fast) {
		   slow = slow.next;
		   fast = fast.next;
	   }
	   return slow;
   }
	public static void main(String[] args) {
    	LinkedList list1 = new LinkedList();
    	LinkedList list2 = new LinkedList();
    	
		list1 = insert(list1,1);
		list1 = insert(list1,2);
		list1 = insert(list1,3);
		list1 = insert(list1,4);
		list1 = addLoop(list1);
		
		list2 = insert(list2,1);
		list2 = insert(list2,2);
		list2 = insert(list2,3);
		list2 = insert(list2,4);
		Node n = loopDetection(list1);
		if(n == null) {
			System.out.println("No loop exists");
		}else {
			System.out.println("Loop starts at = "+n.data);
		}
		Node nn = loopDetection(list2);
		if(nn == null) {
			System.out.println("No loop exists");
		}else {
			System.out.println("Loop starts at = "+nn.data);
		}
		
	}
}
