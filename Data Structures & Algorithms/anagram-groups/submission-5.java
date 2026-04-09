class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returned = new ArrayList<>();

        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] alphabet = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                alphabet[strs[i].charAt(j) - 'a']++;
            }
            String theString = "";
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] > 0) { 
                    theString += (j + "#" + alphabet[j] + "X");
                }
            }
            if (!anagrams.containsKey(theString)) {
                anagrams.put(theString, new ArrayList<>());
            }
            anagrams.get(theString).add(strs[i]);

        }
        for (String possible : anagrams.keySet()) {
            List<String> eachPossible = anagrams.get(possible);
            returned.add(eachPossible);
        }
        return returned;
    }

}
