// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

public class Solution {
    public boolean isSubsequence(String x, String y) {
        int xPointer = 0;
        for (int yPointer = 0; yPointer < y.length() && xPointer < x.length(); yPointer++) {
            if (x.charAt(xPointer) == y.charAt(yPointer)) {
                xPointer++;
            }
        }
        return xPointer == x.length();
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                boolean isLonger = word.length() > longestWord.length();
                boolean isLexicographicallySmaller = word.length() == longestWord.length() 
                                                     && word.compareTo(longestWord) < 0;
                if (isLonger || isLexicographicallySmaller) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }
}
