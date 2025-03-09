// https://leetcode.com/problems/reverse-integer/description/

class Solution {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;

        x = Math.abs(x);

        long xr = 0; 
        
        while (x != 0) {
            int r = x % 10;
            x /= 10;
            xr = xr * 10 + r;
        }
        
        xr *= sign;

        if (xr > Integer.MAX_VALUE || xr < Integer.MIN_VALUE) {  
            return 0;
        }

        return (int)xr;
    }
}
