class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", n, result);
        return result;
    }

    private void generateParenthesis(int openLeft, String soFar, int closedLeft, List<String> result) {
        if (openLeft == 0 && closedLeft == 0) {
            result.add(soFar);
        } else {
            if (openLeft == closedLeft) { // add (
                soFar += "(";
                generateParenthesis(openLeft - 1, soFar, closedLeft, result);
                soFar = soFar.substring(0, soFar.length() - 1);
            } else if (openLeft < closedLeft && openLeft > 0) {
                soFar += "(";
                generateParenthesis(openLeft - 1, soFar, closedLeft, result);
                soFar = soFar.substring(0, soFar.length() - 1);
                soFar += ")";
                generateParenthesis(openLeft, soFar, closedLeft - 1, result);
                soFar = soFar.substring(0, soFar.length() - 1);
            } else {
                soFar += ")";
                generateParenthesis(openLeft, soFar, closedLeft - 1, result);
                soFar = soFar.substring(0, soFar.length() - 1);
            }
        }
    }

    


}

