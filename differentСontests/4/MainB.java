import java.util.*;

public class MainB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] data = new int[n][];
        int[] sizes = new int[n];
        int[] medianTargets = new int[n];

        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            sizes[i] = size;
            data[i] = new int[size];
            for (int j = 0; j < size; j++) {
                data[i][j] = in.nextInt();
            }

            Arrays.sort(data[i]);
            medianTargets[i] = data[i][size / 2];
        }

        int T = in.nextInt();
        in.close();

        int[] result = distributeJars(medianTargets, T, n);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] distributeJars(int[] medianTargets, int T, int n) {
        int[] result = Arrays.copyOf(medianTargets, n);
        int total = Arrays.stream(result).sum();

        if (total < T) {
            int remainder = T - total;
            while (remainder > 0) {
                for (int i = 0; i < n && remainder > 0; i++) {
                    result[i]++;
                    remainder--;
                }
            }
        } else if (total > T) {
            int remainder = total - T;
            while (remainder > 0) {
                for (int i = 0; i < n && remainder > 0; i++) {
                    if (result[i] > 0) {
                        result[i]--;
                        remainder--;
                    }
                }
            }
        }

        return result;
    }
}
