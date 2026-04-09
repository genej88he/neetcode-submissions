class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Move left pointer forward if it's not a letter or number
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 
            // Move right pointer backward if it's not a letter or number
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } 
            // Now that both are on "valid" characters, compare them
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
