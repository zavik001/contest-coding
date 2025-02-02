import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainF {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isNonDegenerate(Point p1, Point p2, Point p3) {
        long area = (long) p1.x * (p2.y - p3.y) + (long) p2.x * (p3.y - p1.y) + (long) p3.x * (p1.y - p2.y);
        return area != 0;
    }

    static int maxHappyTriples(List<Point> points) {
        int n = points.size();
        boolean[] used = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (used[j])
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (used[k])
                        continue;
                    if (isNonDegenerate(points.get(i), points.get(j), points.get(k))) {
                        used[i] = used[j] = used[k] = true;
                        count++;
                        break;
                    }
                }
                if (used[j])
                    break;
            }
            if (used[i])
                continue;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x, y));
        }

        in.close();

        System.out.println(maxHappyTriples(points));
    }
}
