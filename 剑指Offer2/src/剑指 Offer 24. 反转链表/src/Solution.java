import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode p=head;
        for (int i = 1; i < 4; i++) {
            ListNode newNode=new ListNode();
            newNode.val=i;
            p.next=newNode;
            p=p.next;
        }
        p=head;
        while (p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println();

        head=new Solution().reverseList(head.next);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    /**
     * 时间复杂度应该也是O(n),遍历两次链表,为链表的长度
     * 空间复杂度应该也是O(n),用一个stack存储链表,为链表的长度
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack=new LinkedList();
        ListNode p=head;
        while (p!=null){
            stack.push(p);  //这里会自动装箱
            p=p.next;
        }
        ListNode newHead=stack.poll();
        p=newHead;
        int size=stack.size();
        for (int i=0;i<size;i++) {
            ListNode curNode=stack.pop();
            if(i==size-1){
                // 防止链表首尾相连
                curNode.next=null;
            }
            p.next=curNode;
            p=p.next;
        }
        p=null;
        return newHead;
    }
}
