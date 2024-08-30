import java.util.*;
import java.io.*;

public class IndexAndMaxValue {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[] a = new int[n];
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] delta = new int[n + 1]; 
            int maxVal = Integer.MIN_VALUE;
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(reader.readLine());
                char op = st.nextToken().charAt(0);
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                
                for (int j = 0; j < n; j++) {
                    if (a[j] >= l && a[j] <= r) {
                        if (op == '+') {
                            delta[j]++;
                        } else if (op == '-') {
                            delta[j]--;
                        }
                    }
                }
                
                maxVal = Integer.MIN_VALUE;
                for (int j = 0; j < n; j++) {
                    a[j] += delta[j];
                    maxVal = Math.max(maxVal, a[j]);
                }
                
                Arrays.fill(delta, 0);
                
                result.append(maxVal).append(' ');
            }
            result.append('\n');
        }
        
        System.out.print(result.toString());
    }
}
