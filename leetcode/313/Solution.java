public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int i, j, size;
        int[] index;
        int[] ugly = new int[n];

        ugly[0] = 1;
        size = 1;
        index = new int[primes.length];
        for (i = 0; i < primes.length; i++)
            index[i] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
                (e1, e2) -> (primes[e1] * ugly[index[e1]] - primes[e2] * ugly[index[e2]]));

        for (i = 0; i < primes.length; i++)
            queue.add(i);
        while (size < n) {
            i = queue.poll();
            j = primes[i] * ugly[index[i]];
            if (j > ugly[size - 1]) {
                ugly[size] = j;
                size++;
            }
            index[i]++;
            queue.add(i);
        }
        return ugly[n - 1];
    }
}