import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Item implements Comparable<Item> {
        int color;
        int type;

        Item(int color, int type) {
            this.color = color;
            this.type = type;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(this.color, o.color);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Item> all = new ArrayList<>();
        for (int t = 0; t < 4; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                all.add(new Item(Integer.parseInt(st.nextToken()), t));
            }
        }
        Collections.sort(all);
        int[] count = new int[4];
        int covered = 0;
        int left = 0;
        int bestDiff = Integer.MAX_VALUE;
        int bestL = 0, bestR = 0;
        for (int right = 0; right < all.size(); right++) {
            int type = all.get(right).type;
            if (count[type] == 0)
                covered++;
            count[type]++;
            while (covered == 4) {
                int diff = all.get(right).color - all.get(left).color;
                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestL = left;
                    bestR = right;
                }
                int leftType = all.get(left).type;
                count[leftType]--;
                if (count[leftType] == 0)
                    covered--;
                left++;
            }
        }
        int[] ans = new int[4];
        boolean[] found = new boolean[4];
        for (int i = bestL; i <= bestR; i++) {
            int type = all.get(i).type;
            if (!found[type]) {
                ans[type] = all.get(i).color;
                found[type] = true;
            }
        }
        writer.write(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3]);
        writer.newLine();
        reader.close();
        writer.close();
    }
}
