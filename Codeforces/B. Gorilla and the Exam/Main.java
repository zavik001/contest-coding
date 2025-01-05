// https://codeforces.com/contest/2057/problem/B

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            int distinct = freq.size();
            
            List<Integer> frequencies = new ArrayList<>(freq.values());
            Collections.sort(frequencies);
            
            for (int count : frequencies) {
                if (k >= count) {
                    k -= count;
                    distinct--;
                } else {
                    break;
                }
            }

            System.out.println(Math.max(distinct, 1));
        }

        input.close();
    }
}
