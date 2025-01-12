// https://leetcode.com/problems/add-bold-tag-in-string/description/

public class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] bold = new boolean[n];
        
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    bold[i] = true;
                }
                start = s.indexOf(word, start + 1);
            }
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (bold[i]) {
                result.append("<b>");
                while (i < n && bold[i]) {
                    result.append(s.charAt(i));
                    i++;
                }
                result.append("</b>");
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        
        return result.toString();
    }
}
