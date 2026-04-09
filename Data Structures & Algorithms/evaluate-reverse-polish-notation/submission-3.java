class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) {
                int first = stack.pop();
                int second = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(first + second);
                } else if (tokens[i].equals("*")) {
                    stack.push(first * second);
                } else if (tokens[i].equals("-")) {
                    stack.push(second - first);
                } else if (tokens[i].equals("/")) {
                    stack.push(second / first);
                }   
            } else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
