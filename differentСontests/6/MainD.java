import java.util.Scanner;
import java.util.Arrays;

public class MainD {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long n = in.nextLong();
            long m = in.nextLong();
            int u = in.nextInt();
            int v = in.nextInt();

            long[] verticalLines = new long[u + 1];
            verticalLines[0] = n;
            for (int i = 1; i <= u; i++) {
                verticalLines[i] = in.nextLong();
            }

            long[] horizontalLines = new long[v + 1];
            horizontalLines[0] = m;
            for (int i = 1; i <= v; i++) {
                horizontalLines[i] = in.nextLong();
            }

            Arrays.sort(verticalLines);
            Arrays.sort(horizontalLines);

            int q = in.nextInt();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < q; i++) {
                long x1 = in.nextLong();
                long y1 = in.nextLong();
                long x2 = in.nextLong();
                long y2 = in.nextLong();

                int regionX1 = findRegion(verticalLines, x1);
                int regionX2 = findRegion(verticalLines, x2);
                int regionY1 = findRegion(horizontalLines, y1);
                int regionY2 = findRegion(horizontalLines, y2);

                if (regionX1 == regionX2 && regionY1 == regionY2) {
                    output.append("YES\n");
                } else {
                    output.append("NO\n");
                }
            }

            System.out.print(output);
        }
    }

    private static int findRegion(long[] lines, long coordinate) {
        int left = 0, right = lines.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lines[mid] > coordinate) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
