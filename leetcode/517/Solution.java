// https://leetcode.com/problems/super-washing-machines/description/

class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int dresses : machines) {
            total += dresses;
        }
        
        int n = machines.length;
        if (total % n != 0) {
            return -1;
        }
        
        int average = total / n;
        int moves = 0;
        int balance = 0;
        
        for (int dresses : machines) {
            int diff = dresses - average;
            balance += diff;
            moves = Math.max(moves, Math.max(Math.abs(balance), diff));
        }
        
        return moves;
    }
}
