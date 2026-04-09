class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        int halfLength = s.length / 2;
        for (int i = 0; i < halfLength; i++) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}