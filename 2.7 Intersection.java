import java.util.HashMap;
import java.util.HashSet;
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
   
    
    
    public static Node intersection(LinkedList list1, LinkedList list2) {
    	return intersection(list1.head,list2.head);
    }
    public static Node intersection(Node n1, Node n2) {
    	
    	HashSet<Node> set = new HashSet<Node>();
    	while(n1 != null) {
    		set.add(n1);
    		n1 = n1.next;
    	}
    	
    	while(n2 != null) {
    		
    		if(set.contains(n2)) {
    			return n2;
    		}
    		n2 = n2.next;
    	}
    	return null;
    }
    public static void addIntersectionPoint(Node n1, Node n2) {
    	while(n1.next != null) {
    		n1 = n1.next;
    	}
    	while(n2.next != null) {
    		n2 = n2.next;
    	}
    	
    	// add three extra node
    	for(int i=0; i<3;i++)
    	{
    		Node n = new Node(10+i);
    		n1.next = n;
    		//System.out.println("here");
    		n2.next = n;
    		n1 = n1.next;
    		n2 = n2.next;
    	}
    	
    }
	public static void main(String[] args) {
    	LinkedList list1 = new LinkedList();
    	LinkedList list2 = new LinkedList();
    	
		list1 = insert(list1,7);
		list1 = insert(list1,7);
		list1 = insert(list1,2);
		list1 = insert(list1,3);
		list1 = insert(list1,2);
		
		list2 = insert(list2,7);
		list2 = insert(list2,1);
		list2 = insert(list2,1);
		// lists before intersection
		printlist(list1);
		printlist(list2);
		Node n = intersection(list1,list2);
		if(n == null) {
			System.out.println("Lists have no intersection");
		}else {
			System.out.println("Intersecting node = "+n.data);
			
		}
		
		
		// adding intersection nodes
		addIntersectionPoint(list1.head,list2.head);
		printlist(list1);
		printlist(list2);
		
		n = intersection(list1,list2);
		if(n == null) {
			System.out.println("Lists have no intersection");
		}else {
			System.out.println("Intersecting node = "+n.data);
			
		}
		
	}
}
