import java.util.*;

public class MainD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        for (int par = 0; par < 2; par++) {
            Stack<Integer> st = new Stack<>();
            for (int ii = N - 1; ii >= 0; ii--) {
                if (ii % 2 != par)
                    continue;
                while (!st.isEmpty() && h[st.peek()] <= h[ii])
                    st.pop();
                if (!st.isEmpty())
                    ans[ii] = st.peek() - ii;
                st.push(ii);
            }
        }
        for (int i = 0; i < N; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(ans[i]);
        }
        System.out.println();
        sc.close();
    }
}
