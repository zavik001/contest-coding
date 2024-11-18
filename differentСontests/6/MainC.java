import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        in.close();

        int left = 0, modified = 0, maxBuildings = 0;

        for (int right = 0; right < n; right++) {
            if (heights[right] >= k) {
                modified++;
            }

            while (modified > q) {
                if (heights[left] >= k) {
                    modified--;
                }
                left++;
            }

            maxBuildings = Math.max(maxBuildings, right - left + 1);
        }

        System.out.println(maxBuildings);
    }
}
