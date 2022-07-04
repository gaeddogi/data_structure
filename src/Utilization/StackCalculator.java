package Utilization;

import javax.swing.plaf.IconUIResource;
import java.net.InterfaceAddress;
import java.util.Stack;

public class StackCalculator {
    public static void main(String args[]) {
        String postfix = conPostfix("((4+2)/4)-(3+2/(7*5))");
        System.out.println(postfix);
        System.out.println(postfixCalculator(postfix));

    }

    public static int getOpPriority(char op) {
        switch (op) {
            case '*':
            case '/':
                return 5;

            case '+':
            case '-':
                return 3;

            case '(':
                return 1;

            default:
                return -1;
        }
    }

    public static int compareOp(char stackOp, char curOp) {
        int stackOpPriority = getOpPriority(stackOp);
        int curOpPriority = getOpPriority(curOp);

        if (stackOpPriority < curOpPriority) {
            return 1;
        }
        else if (stackOpPriority == curOpPriority) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public static String conPostfix(String infix) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char x = infix.charAt(i);

            if (Character.isDigit(x)) {
                sb.append(x);
            }
            else if (stack.empty()) {
                stack.push(x);

            }
            else {

                if (x == '(') {
                    stack.push(x);
                }
                else if (x == ')') {
                    char c = stack.pop();
                    while (c != '(') {
                        sb.append(c);
                        c = stack.pop();
                    }
                }


                else if (compareOp(stack.peek(), x) > 0) {
                    stack.push(x);
                }

                else if (compareOp(stack.peek(), x) <= 0) {
                    //stack이 비어있지 않을 경우 반복하는 거임
                    while (!stack.isEmpty()) {

                        if (compareOp(stack.peek(), x) <= 0) {
                            sb.append(stack.pop());
                        }
                        // else 안 써주면 무한루프
                        else {
                            break;
                        }

                    }
                    stack.push(x);
                }

            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != '(') {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }

    public static Double postfixCalculator(String postfix) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < postfix.length(); i++) {
            char x = postfix.charAt(i);
            //숫자
            if (Character.isDigit(x)) {
                stack.push(Integer.parseInt(String.valueOf(x)));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (x) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        return Double.valueOf(stack.pop());
    }
}
