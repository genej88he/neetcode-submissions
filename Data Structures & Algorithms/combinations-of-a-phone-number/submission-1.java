class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(digits, map, "", 0, result);
        return result;
    }

    private void backtrack(String digits, Map<Character, String> map, String soFar, int index, List<String> result) {
        if (index != digits.length()) {
            System.out.println(soFar);
            Character thisIndex = digits.charAt(index);
            String correlated = map.get(thisIndex);
            for (int i = 0; i < correlated.length(); i++) {
                soFar += correlated.charAt(i) + "";
                backtrack(digits, map, soFar, index + 1, result);
                int length = soFar.length();
                soFar = soFar.substring(0, length - 1);
            }
        }
        if (soFar.length() == digits.length()) {
            result.add(soFar);
        }
        
    }
}
