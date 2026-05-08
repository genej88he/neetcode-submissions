class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, 0, new ArrayList<String>());
        
        return result;
    }

    private void backtrack(String s, List<List<String>> result, int start, List<String> soFar) {
        if (start == s.length()) {
            result.add(new ArrayList<>(soFar));
        } else {
            for (int end = start + 1; end <= s.length(); end++) {
                String subString = s.substring(start, end);
                if (isPalindrome(subString)) {
                    soFar.add(subString);
                    backtrack(s, result, end, soFar);
                    soFar.remove(soFar.size() - 1);
                }
            }
        }
        
    }

    private boolean isPalindrome(String subString) {
        int left = 0;
        int right = subString.length() - 1;
        while (left < right) {
            if (subString.charAt(left) != subString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
