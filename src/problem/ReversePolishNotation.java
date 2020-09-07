package problem;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        Integer n1 = 0;
        Integer n2 = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    n1 = numbers.pop();
                    n2 = numbers.pop();
                    numbers.push(n1 + n2);
                    break;
                case "-":
                    n1 = numbers.pop();
                    n2 = numbers.pop();
                    numbers.push(n2 - n1);
                    break;
                case "*":
                    n1 = numbers.pop();
                    n2 = numbers.pop();
                    numbers.push(n1 * n2);
                    break;
                case "/":
                    n1 = numbers.pop();
                    n2 = numbers.pop();
                    numbers.push(n2 / n1);
                    break;
                default:
                    numbers.push(Integer.parseInt(s));
            }
        }
        return numbers.pop();
    }

}
