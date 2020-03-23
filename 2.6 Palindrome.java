import java.util.Stack;

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
        while(current!=null){
            System.out.print(" "+current.data);
            current = current.next;
        }
        System.out.println();
        return true;
    }
   
    public static boolean isPalindrome(LinkedList list) {
    	Node fast = list.head;
    	Node slow = list.head;
    	//  stack to store value in reverse order
    	Stack<Integer> stack = new Stack<Integer>();
    
    	while(fast != null && fast.next != null) {
    		stack.push(slow.data);
    		slow = slow.next;
    		fast = fast.next.next; // 2X speed 
    		
    	}
    	
    	if(fast != null) {
    		slow = slow.next;
    	}
    	while(slow != null) {
    		int val =  stack.pop().intValue();
    		if( val != slow.data) {
    			return false;
    		}
    		slow = slow.next;
    	}
    	return true;
    }
	public static void main(String[] args) {
    	LinkedList list1 = new LinkedList();
    	LinkedList list2 = new LinkedList();
    	
		list1 = insert(list1,7);
		list1 = insert(list1,1);
		list1 = insert(list1,6);
		list1 = insert(list1,6);
		list1 = insert(list1,1);
		list1 = insert(list1,7);
		
		list2 = insert(list2,5);
		list2 = insert(list2,9);
		list2 = insert(list2,2);
		list2 = insert(list2,3);
		list2 = insert(list2,2);
		list2 = insert(list2,9);
		list2 = insert(list2,5);
		System.out.println(isPalindrome(list1));
		System.out.println(isPalindrome(list2));
		
	}
}
