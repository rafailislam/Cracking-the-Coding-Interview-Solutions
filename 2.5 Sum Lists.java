
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
   public static LinkedList sumReverse(LinkedList list1, LinkedList list2) {
	   LinkedList list = new LinkedList();
	   
	   Node n1 = list1.head;
	   Node n2 = list2.head;
	   int c = 0;
	   while(n1 != null || n2 != null || c !=0 ) {
		   int sum = c;
		   if(n1 != null) {
			   sum += n1.data;
			   n1 =  n1.next;
		   }
		   if(n2 != null) {
			   sum += n2.data;
			   n2 =  n2.next;
		   }
		   c = sum/10;
		   sum = sum%10;
		   list = insert(list,sum);
	   }
	   return list;
   }
   static class wrapInt{
	   int value;
	   wrapInt(int x){
		   this.value = x;
	   }
   }
   public static LinkedList sumForward(LinkedList list1, LinkedList list2) {
	   LinkedList list = new LinkedList();
	   
	   int len1 = length(list1);
	   int len2 = length(list2);
	   if(len1 > len2) {
		   list2 = padding(list2, len1-len2);
	   }else {
		   list1 = padding(list1, len2-len1);
	   }
	   
	   wrapInt carry = new wrapInt(0);
	   return sumForward(list1.head, list2.head,list,carry) ;
   }
   public static LinkedList padding(LinkedList list, int n) {
	   for(int i =0; i< n; i++) {
		   Node new_node = new Node(0);
		   new_node.next =  list.head;
		   list.head = new_node;
	   }
	   return list;
   }
   public static LinkedList sumForward(Node n1, Node n2, LinkedList list,wrapInt carry) {
	   if(n1 == null && n2 == null && carry.value == 0) {
		   return list;
	   }
	   
	   list = sumForward(n1 == null? null: n1.next,n2 == null? null: n2.next,list,carry);
	   int sum;
	   sum = carry.value;
	   
	   if(n1 != null) {
		   sum += n1.data;
	   }
	   if(n2 != null) {
		   sum += n2.data;
	   }
	   carry.value = sum/10;
	   sum = sum%10;
	  
	   Node new_node = new Node(sum);
	   
	   if(list.head == null) {
		   new_node.next = null;
		   list.head = new_node;
	   }else {
		   new_node.next = list.head;
		   list.head = new_node;
	   }
	   return list;
   }
   public static int length(LinkedList list) {
	   int len=0;
	   Node current = list.head;
	   while(current!=null) {
		   len++;
		   current = current.next;
	   }
	   return len;
   }
	public static void main(String[] args) {
    	LinkedList list1 = new LinkedList();
    	LinkedList list2 = new LinkedList();
    	LinkedList list3 = new LinkedList();
    	LinkedList list4 = new LinkedList();
		list1 = insert(list1,7);
		list1 = insert(list1,1);
		list1 = insert(list1,6);
			
		list2 = insert(list2,5);
		list2 = insert(list2,9);
		list2 = insert(list2,2);
		
		list3 = insert(list3,4);
		list3 = insert(list3,6);
		list3 = insert(list3,1);
		list3 = insert(list3,7);
		
	
		list4 = insert(list4,2);
		list4 = insert(list4,9);
		list4 = insert(list4,5);
		System.out.println("Sum of the lists: ");
		printlist(list1);
		printlist(list2);
		System.out.print("Reverse order Sum : ");
		printlist(sumReverse(list1,list2));
		
		System.out.println("Sum of the lists: ");
		printlist(list3);
		printlist(list4);
		System.out.print("Forward order Sum : ");
		printlist(sumForward(list3,list4));
	}
}
