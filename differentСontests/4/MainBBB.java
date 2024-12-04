import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBBB {

    public static int calcDifference(List<List<Integer>> P, List<Integer> sizes, List<Integer> Ti) {
        int totalDiff = 0;
        for (int i = 0; i < P.size(); i++) {
            for (int j = 0; j < sizes.get(i); j++) {
                totalDiff += Math.abs(P.get(i).get(j) - Ti.get(i));
            }
        }
        return totalDiff;
    }

    public static boolean canDistributeWithMaxDiff(List<List<Integer>> P, List<Integer> sizes, int T, int maxDiff) {
        int n = P.size();
        List<Integer> Ti = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            int totalCucumbers = P.get(i).stream().mapToInt(Integer::intValue).sum();
            int jars = totalCucumbers / maxDiff;
            Ti.add(jars);
            T -= jars;
        }

        if (T < 0) return false;

        for (int i = 0; i < n && T > 0; i++) {
            Ti.set(i, Ti.get(i) + 1);
            T--;
        }

        return calcDifference(P, sizes, Ti) <= maxDiff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> P = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            sizes.add(size);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(scanner.nextInt());
            }
            P.add(row);
        }

        int T = scanner.nextInt();

        
        int left = 0;
        int right = (int) 1e9;  
        while (left < right) {
            int mid = (left + right) / 2;
            if (canDistributeWithMaxDiff(P, sizes, T, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        
        System.out.println(left);
        scanner.close();
    }
}
