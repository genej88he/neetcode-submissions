class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // window be of length s1
        int left = 0;
        int count = s1.length();
        String newString = s1;
        for (int right = 0; right < s2.length(); right++) {
            String ind = s2.substring(right, right + 1);
            if (newString.contains(ind)) {
                count--;
                int found = newString.indexOf(ind);
                newString = newString.substring(0, found) + newString.substring(found + 1, newString.length());

            } else {
                count = s1.length();
                newString = s1;
                right = left;
                left++;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
