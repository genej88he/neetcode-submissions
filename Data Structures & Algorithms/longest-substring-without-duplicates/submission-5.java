class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        
        Set<Character> contained = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            while (contained.contains(currentChar)) {
                contained.remove(s.charAt(left));
                left++;
            }

            contained.add(currentChar);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;

    }
}
