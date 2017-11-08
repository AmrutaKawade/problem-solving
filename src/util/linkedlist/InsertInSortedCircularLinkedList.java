package util.linkedlist;

public class InsertInSortedCircularLinkedList {
 public static Node insertInLinkedList(Node head, int data){
       Node node = head;
       //Add Node If List is Empty
       if(node==null){
    	   Node temp = new Node(data);
    	   temp.next = temp;
       }
            
       //Add Node At the start of the list
       else if(data <= node.data){
    	   Node temp = new Node(data);
    	   temp.next = node;
    	   while(node.next != head){
    		  node = node.next; 
    	   };
    	   node.next = temp;
    	   head = temp;
       }
       
       //Add Node In between
       else {
    	   Node prev = node;
    	   Node curr = node;
           do{
               if(prev.data <= data &&  data < curr.data){
                   break;
               }
               prev = curr;
               curr = curr.next; 
           }while(curr != head);
           insertNode(data,prev,curr);
       }
       
       return head;
   }
   private static void insertNode(int data, Node prev, Node curr) {
	   Node temp = new Node(data);
       prev.next = temp;
       temp.next = curr;
   }
   public static void main(String[] args){
	   //Input data
	   int[] arr1 = {2,4,6,8,9,10,11,12,14,15,16};//{2,3,6,10,15,21,28};
	   LinkedList l = new LinkedList();
	   Node node = l.createCircularLinkedList(arr1);
	   int dataToInsert = 7;
	   node = insertInLinkedList(node,dataToInsert);
	   l.printCircularLinkedList(node);
   }
}
