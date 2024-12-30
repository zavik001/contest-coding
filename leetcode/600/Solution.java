class Solution {
    public int findIntegers(int n) {
        int[] fib = new int[32];
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i < 32; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        int prevBit = 0, result = 0;

        for (int i = 30; i >= 0; i--) {
            int currentBit = (n >> i) & 1;
            if (currentBit == 1) {
                result += fib[i];
                if (prevBit == 1) {
                    return result;
                }
            }
            prevBit = currentBit;
        }

        return result + 1;
    }
}
