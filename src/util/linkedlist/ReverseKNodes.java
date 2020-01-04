package util.linkedlist;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }      
}
public class ReverseKNodes {
	public static void main(String[] args) {
		int k = 4;
		int[] arr = {1,2,3};
		ListNode node = null;
		ListNode head = null;
		for(int item: arr) {
			if(node == null) {
				node = new ListNode(item);
				head = node;
			}else {
				ListNode temp = new ListNode(item);
				node.next = temp;
				node = temp;
			}
		}	
		ListNode reversed = reverseKGroup(head,k);
		while(reversed != null) {
			System.out.print(reversed.val+" ");
			reversed = reversed.next;
		}
	}
	
	static ListNode start = null;
   
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while(count < k && node != null){
            node = node.next;
            count++;
        }
        if(count == k) {
        	 ListNode reversed = reverseKGroup(node, k);
        	 ListNode reverseLastNode = reverseList(head, k);
        	 reverseLastNode.next = reversed;
        	 head = start;
        }
        return head;
    }
    
    public static ListNode reverseList(ListNode head, int k){
        if(k == 1){
           start = head;
           return head;
        }
        ListNode ref = reverseList(head.next, k-1);
        ref.next = head;
        return head;
    }
}
