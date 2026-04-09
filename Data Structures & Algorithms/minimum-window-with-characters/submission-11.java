class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!freq.containsKey(t.charAt(i))) {
                freq.put(t.charAt(i), 1);
            } else {
                freq.put(t.charAt(i), freq.get(t.charAt(i)) + 1);
            }
        }

        Map<Character, Integer> test = new HashMap<>();
        int left = 0;
        String subString = "";
        int minLen = Integer.MAX_VALUE;

        int formed = 0;
        for (int right = left; right < s.length(); right++) {
            Character get = s.charAt(right);
            if (freq.containsKey(get)) {
                if (!test.containsKey(get)) {
                    test.put(get, 1);
                } else {
                    test.put(get, test.get(get) + 1);
                }

                if (freq.get(get) == test.get(get)) {
                    formed++;
                }
            }
            while (formed == freq.size()) {
                Character past = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    subString = s.substring(left, right + 1);
                }

                
                if (test.containsKey(past)) {
                    if (freq.get(past) == test.get(past)) {
                        formed--;
                    }
                    test.put(past, test.get(past) - 1);
                    
                }
                left++;
            }
        }


        
        return subString;
    }
}
