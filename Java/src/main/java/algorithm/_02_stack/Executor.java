package algorithm._02_stack;

public class Executor {

    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("===== 첫 번째 출력 =====");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);

        System.out.println("===== 두 번째 출력 =====");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek().data);
        stack.pop();
        System.out.println(stack.peek().data);
        System.out.println(stack.isEmpty());    // false
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }
}
