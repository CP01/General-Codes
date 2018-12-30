package cp;

public class Test {

	public static void main(StringRelated[] args) {

		LinkedListNode node = new LinkedListNode(5);
		node = add(node, 3);
		node = add(node, 1);
		print(node);
		sort(3,node);
		print(node);
	}

	static void print(LinkedListNode node)
	{
		while(node.next!=null)
		{
			System.out.print(node.val + " - ");
			node = node.next;
		}
		System.out.println();
	}
	static LinkedListNode add(LinkedListNode node, int n)
	{
		LinkedListNode root = node;
		while(node.next!=null)
			node = node.next;
		LinkedListNode newNode = new LinkedListNode(n);
		node.next = newNode;
		return root;
	}
	
	static LinkedListNode sort(int k, LinkedListNode list) {
	    // Write your code here.
	    LinkedListNode head = list;
	    while(list.next!=null)
	    {
	        LinkedListNode arr[] = new LinkedListNode[k];
	        for(int i=0;i<k;i++)
	        {
	            if(list.next != null) {
	               list = list.next;
	                arr[i] = list;
	            }
	        }
	        LinkedListNode first = arr[0];
	        LinkedListNode nextNode = null;
	        if(k>0 && arr[k-1] != null)
	        	nextNode = arr[k-1].next;
	        
	        for(int j=1;j<k;j++)
	        {
	            for(int l=j-1;l>=0;l--)
	            {
	                if(arr[j] != null && arr[l] != null && arr[j].val<arr[l].val)
	                {
	                    LinkedListNode tmp = arr[j];
	                    arr[j] = arr[l];
	                    arr[l] = tmp;
	                }
	            }
	        }
	        list.next = arr[0];
	        for(int m=0;m<k-1;m++)
	        {
	        	if(arr[m] != null)
	        		arr[m].next = arr[m+1];
	        }
	        if(nextNode!=null && k>0)
	        arr[k-1].next = nextNode;
	    }
	    return head;
	}



}
/*
 * Complete the function below.
 */
/*
For your reference:
*/
class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode(int n){
    	val = n;
    	next = null;
    }
}

