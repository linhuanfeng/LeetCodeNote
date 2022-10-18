public class CQueue {
    transient int size=0;
    transient MyNode<Integer> first;
    transient MyNode<Integer> last;

    public CQueue() {

    }

    public void appendTail(int value) {
        final MyNode<Integer> l=last;
        final MyNode<Integer> newNode=new MyNode<Integer>(l,value,null);
        last=newNode;
        if(l==null){
            first=newNode;
        }else {
            // 尾节点连上新节点
            l.next=newNode;
        }
        size++;
    }

    public int deleteHead() {
        if(first==null){
            return -1;
        }
        Integer element=first.item;
        MyNode<Integer> next=first.next;
        first=next;
        if (next==null){
            last=null; // 当前队列变成空
        }else {
            next.prev=null;// 队头元素的前驱节点为空
        }
        size--;
        return element;
    }

    private class MyNode<E>{
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(MyNode<E> prev,E element,MyNode<E> next){
            this.item=element;
            this.next=next;
            this.prev=prev;
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */