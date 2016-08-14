
##1
```
public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;     // Avoid null pointer
        ListNode fast = head;
        ListNode slow = dummy;
        
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // slow = [3,4,5]
        // fast = []
        // dummy = [0,1,2,3,4,5]
        
        slow.next = slow.next.next;
        
        // slow = [3,5]
        // dummy = [0,1,2,3,5]
        
        return dummy.next;    // dummy starts with 0
    }
```
---
Why dummy and slow are related?  


---
Why 
[1,2,3,4,5,6]
```
slow.next = slow.next.next;
```
will change both dummy and slow (but not head) whereas 
```
slow = slow.next;
//or
slow = slow.next.next;
```
will only change slow, not dummy
---
If we retain both 
```
dummy.next = head;
slow.next = head;
```
[1] 1 will return [1] instead of [], so we need to discard one of them
