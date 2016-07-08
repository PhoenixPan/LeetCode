
##1
```
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        //slow.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
```
If we retain both 
```
dummy.next = head;
slow.next = head;
```
[1] 1 will return [1] instead of [], so we need to discard one of them

##2
[1,2,3,4,5,6]
```
slow.next = slow.next.next;
```
will change both dummy and slow (to [2,3,4,5,6]) whereas 
```
slow = slow.next;
//or
slow = slow.next.next;
```
will only change slow, not dummy
