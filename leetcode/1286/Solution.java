// https://leetcode.com/problems/iterator-for-combination/

class CombinationIterator {
    private List<String> combinations;
    private int index;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        generateCombinations(characters, combinationLength, 0, new StringBuilder());
        index = 0;
    }

    private void generateCombinations(String chars, int len, int start, StringBuilder sb) {
        if (sb.length() == len) {
            combinations.add(sb.toString());
            return;
        }
        for (int i = start; i < chars.length(); i++) {
            sb.append(chars.charAt(i));
            generateCombinations(chars, len, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return combinations.get(index++);
    }

    public boolean hasNext() {
        return index < combinations.size();
    }
}