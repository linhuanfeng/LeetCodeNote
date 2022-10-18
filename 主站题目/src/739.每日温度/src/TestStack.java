import java.util.Stack;

public class TestStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.empty());// 为空则返回true

        stack.push(1);
        stack.push(2);//入栈
        System.out.println(stack.peek());// 取栈顶元素2
        System.out.println(stack.pop());// 出栈
        System.out.println(stack.pop());
        try {
            System.out.println(stack.pop());// 此时栈为空，报java.util.EmptyStackException
        }catch (java.util.EmptyStackException e){
            System.out.println(e);
        }
        try{
            System.out.println(stack.peek());// 此时栈为空，报java.util.EmptyStackException
        }catch(java.util.EmptyStackException e){
            System.out.println(e);
        }
    }

}
