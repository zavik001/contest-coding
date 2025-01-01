// https://leetcode.com/problems/design-compressed-string-iterator/description/

class StringIterator {
    private String compressedString;
    private int index;
    private char currentChar;
    private int currentCount;

    public StringIterator(String compressedString) {
        this.compressedString = compressedString;
        this.index = 0;
        this.currentChar = ' ';
        this.currentCount = 0;
        advance();
    }

    public char next() {
        if (!hasNext()) return ' ';
        char result = currentChar;
        currentCount--;
        if (currentCount == 0) advance();
        return result;
    }

    public boolean hasNext() {
        return currentCount > 0 || index < compressedString.length();
    }

    private void advance() {
        if (index >= compressedString.length()) return;
        currentChar = compressedString.charAt(index++);
        StringBuilder countBuilder = new StringBuilder();
        while (index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
            countBuilder.append(compressedString.charAt(index++));
        }
        currentCount = Integer.parseInt(countBuilder.toString());
    }
}
