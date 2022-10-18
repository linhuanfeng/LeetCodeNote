package a142.环形链表II;

/**
 * 快慢指针
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,quick=head; // 有环的话快指针一定会和慢指针相遇
        while (true){ // 相遇说明有环
            if(quick==null||quick.next==null){
                return null;
            }
            slow=slow.next;
            quick=quick.next.next;
            if(slow==quick){ // 相遇说明有环，快指针追上了慢指针
                break;
            }
        }
        // 慢指针再走一遍，和开头指针相遇的就是环的入口
        quick=head;
        while (quick!=slow){
            quick=quick.next;
            slow=slow.next;
        }
        return quick;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(new Solution().detectCycle(node1).val);
    }
}