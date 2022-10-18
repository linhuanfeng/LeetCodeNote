public class Solution2 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode p=head;
        for (int i = 1; i < 6; i++) {
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
     * 假设链表为 1 \rightarrow 2 \rightarrow 3 \rightarrow \varnothing1→2→3→∅，我们想要把它改成 \varnothing \leftarrow 1 \leftarrow 2 \leftarrow 3∅←1←2←3。
     *
     * 在遍历链表时，将当前节点的 \textit{next}next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     * 时间复杂度应该也是O(n),遍历两次链表,为链表的长度
     * 空间复杂度应该也是O(n),用一个stack存储链表,为链表的长度
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        p1.next=null; // 防止链表产生环
        while (p2!=null){
            ListNode p2_next=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p2_next;
        }
        return p1;
    }
}


