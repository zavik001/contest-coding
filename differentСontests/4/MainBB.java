import java.util.*;

public class MainBB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] data = new int[n][];
        int[] sizes = new int[n];

        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            sizes[i] = size;
            data[i] = new int[size];
            for (int j = 0; j < size; j++) {
                data[i][j] = in.nextInt();
            }
        }

        int T = in.nextInt();
        in.close();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = T / n;
        }

        int remainder = T % n;
        for (int i = 0; i < remainder; i++) {
            result[i]++;
        }

        minimizeDifference(data, sizes, result);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int calcDifference(int[][] data, int[] sizes, int[] result) {
        int totalDiff = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < sizes[i]; j++) {
                totalDiff += Math.abs(data[i][j] - result[i]);
            }
        }
        return totalDiff;
    }

    public static void minimizeDifference(int[][] data, int[] sizes, int[] result) {
        int currentDiff = calcDifference(data, sizes, result);
        boolean improved = true;

        while (improved) {
            improved = false;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    if (i != j && result[i] > 0) {
                        result[i]--;
                        result[j]++;

                        int newDiff = calcDifference(data, sizes, result);
                        if (newDiff < currentDiff) {
                            currentDiff = newDiff;
                            improved = true;
                        } else {
                            result[i]++;
                            result[j]--;
                        }
                    }
                }
            }
        }
    }
}
