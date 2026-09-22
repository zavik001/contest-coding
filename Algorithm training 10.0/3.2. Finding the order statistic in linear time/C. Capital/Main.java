import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine().trim());
        int[] xs = new int[n];
        int[] ys = new int[n];
        Set<Point> occupied = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
            occupied.add(new Point(xs[i], ys[i]));
        }
        int[] sortedX = xs.clone();
        int[] sortedY = ys.clone();
        Arrays.sort(sortedX);
        Arrays.sort(sortedY);
        int medX, medY;
        if (n % 2 == 1) {
            medX = sortedX[n / 2];
            medY = sortedY[n / 2];
        } else {
            medX = sortedX[n / 2 - 1];
            medY = sortedY[n / 2 - 1];
        }
        if (!occupied.contains(new Point(medX, medY))) {
            writer.write(medX + " " + medY);
            writer.newLine();
            reader.close();
            writer.close();
            return;
        }
        long bestSum = Long.MAX_VALUE;
        int bestX = medX, bestY = medY;
        int range = Math.max(20, n + 5);
        for (int dx = -range; dx <= range; dx++) {
            for (int dy = -range; dy <= range; dy++) {
                int cx = medX + dx;
                int cy = medY + dy;
                if (occupied.contains(new Point(cx, cy)))
                    continue;
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += Math.abs(cx - xs[i]) + Math.abs(cy - ys[i]);
                }
                if (sum < bestSum) {
                    bestSum = sum;
                    bestX = cx;
                    bestY = cy;
                }
            }
        }
        writer.write(bestX + " " + bestY);
        writer.newLine();
        reader.close();
        writer.close();
    }
}
