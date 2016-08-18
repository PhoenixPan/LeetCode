##Test cases
```
[]
[1]
[1,2]
[1,2,3]
[1,2,3,4]
[1,2,3,4,5]
```


##Version 1

Primitive brute solution. 1ms but is below 99%.
```
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode result = new ListNode(0);
        ListNode operation = result;
        ListNode even = head.next;
        ListNode odd = head;
        boolean terminate = false;
        while (even != null || odd != null) {
            
            operation.next = new ListNode(even.val);
            operation = operation.next;
            
            if (even.next != null && even.next.next != null) 
                even = even.next.next;
            else 
                terminate = true;
                
            operation.next = new ListNode(odd.val);
            operation = operation.next;
            
            if (odd.next != null && odd.next.next != null) 
                odd = odd.next.next;
            else 
                terminate = true;
            
            if (terminate)
                break;
            // System.out.println(head);
        }
        if (odd != null && odd.next == null)
            operation.next = new ListNode(odd.val);
            
        return result.next;
        
    }
}
```
