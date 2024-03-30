package ktw.advanced.section03;

import java.util.Stack;

class Prob02 {
    public String solution(String s) {
        Stack<String> stack = new Stack<>();
        String answer = "";
        for (char c : s.toCharArray()) {
            if (c == ')') {
                String tmp = "";
                while (!stack.isEmpty()) {
                    String current = stack.pop();
                    if (current.equals("(")) {
                        String res = "";
                        int num = 0;
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = Integer.parseInt(stack.pop());
                        }
                        for (int i = 0; i < num; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;
                    } else {
                        tmp = current + tmp;
                    }
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        for (String string : stack) {
            answer += string;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob02 T = new Prob02();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
