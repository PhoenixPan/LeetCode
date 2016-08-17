##Test case

```
[][]
[1][]
[][1]
[-1,0,5][1,2,3]
```

##First version

Well...this is a 2ms solution, but only beats 2%! We have to do more!
```
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = new ListNode(l2.val);
                l2 = l2.next == null? null : l2.next;
            } else if (l2 == null) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next == null? null : l1.next;
            } else if (l1.val >= l2.val) {
                temp.next = new ListNode(l2.val);
                l2 = l2.next == null? null : l2.next;
            } else if (l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next == null? null : l1.next;
            }
            temp = temp.next;
        }
        
        return result.next;
    }
}
```
