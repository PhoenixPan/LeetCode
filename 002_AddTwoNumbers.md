
Try to make it simple and readable.

```
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode output = new ListNode(0);
        ListNode operation = output;
        int carry = 0;
        
        if (l1 == null && l2 == null)
            return l1;
        
        while (l1 != null || l2 != null || carry > 0) { 
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;           // Get the total of all numbers, which could exceed 9
            carry = sum / 10;                        // Get the carry
            
            operation.next = new ListNode(sum % 10); // Only take the remainder
            operation = operation.next;

            if (l1 != null)                          // Avoid NPE for .next
                l1 = l1.next == null? null : l1.next;
            if (l2 != null)
                l2 = l2.next == null? null : l2.next;
    
        }
        
        return output.next;
    }
}
```
