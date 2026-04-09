class Solution {
    public boolean isValid(String s) {
        Stack<Character> checker = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char type = s.charAt(i);
            if (type == '[' || type == '(' || type == '{') {
                checker.push(type);
            } else {
                if (checker.isEmpty()) {
                    return false;
                }
                char left = checker.pop();
                
                if (left == '[' && s.charAt(i) != ']') {
                    return false;
                }

                if (left == '(' && s.charAt(i) != ')') {
                    return false;
                }

                if (left == '{' && s.charAt(i) != '}') {
                    return false;
                }
            }
        }
        return checker.isEmpty();
    }
}
