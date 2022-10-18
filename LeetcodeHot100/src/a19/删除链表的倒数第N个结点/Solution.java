package a19.删除链表的倒数第N个结点;

/**
 * 快慢双指针
 * 时间：O(n)
 * 空间:O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head,q=head;
        int cnt=0;
        while (q.next!=null&&cnt<n){
            cnt++;
            q=q.next;
        }
        if(cnt!=n){
            // 说明当前头结点是要删除的元素
            return head.next;
        }
        while (q.next!=null){
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        return head;
    }
}