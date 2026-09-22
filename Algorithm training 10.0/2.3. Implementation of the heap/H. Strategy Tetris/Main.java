import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {

    static class Figure {
        int id;
        long left;
        long right;
        int level;

        Figure(int id, long left, long right) {
            this.id = id;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] first = reader.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        long w = Long.parseLong(first[1]);
        Figure[] figures = new Figure[n];
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            long a = Long.parseLong(parts[0]);
            long width = Long.parseLong(parts[1]);
            figures[i] = new Figure(i + 1, a, a + width - 1);
        }
        Figure[] sorted = figures.clone();
        Arrays.sort(sorted, Comparator
                .comparingLong((Figure f) -> f.left)
                .thenComparingLong(f -> f.right));
        PriorityQueue<Figure> active = new PriorityQueue<>(
                Comparator.comparingLong(f -> f.right));
        PriorityQueue<Integer> freeLevels = new PriorityQueue<>();
        int levels = 0;
        for (Figure current : sorted) {
            while (!active.isEmpty() && active.peek().right < current.left) {
                Figure finished = active.poll();
                freeLevels.add(finished.level);
            }
            if (!freeLevels.isEmpty()) {
                current.level = freeLevels.poll();
            } else {
                levels++;
                current.level = levels;
            }
            active.add(current);
        }
        List<Integer>[] groups = new ArrayList[levels + 1];
        for (int i = 1; i <= levels; i++) {
            groups[i] = new ArrayList<>();
        }
        for (Figure figure : figures) {
            groups[figure.level].add(figure.id);
        }
        writer.write(String.valueOf(levels));
        writer.newLine();
        for (int i = 1; i <= levels; i++) {
            for (int j = 0; j < groups[i].size(); j++) {
                if (i != 1 || j != 0) {
                    writer.write(" ");
                }
                writer.write(String.valueOf(groups[i].get(j)));
            }
        }
        writer.newLine();
        reader.close();
        writer.close();
    }
}
