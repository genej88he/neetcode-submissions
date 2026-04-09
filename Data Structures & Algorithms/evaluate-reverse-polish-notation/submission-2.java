class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first + second);
            } else if (tokens[i].equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first * second);
            } else if (tokens[i].equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);

            } else if (tokens[i].equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
