import java.util.Scanner;

public class MainB {

    public static long[] solveFlowerProblem(int n, long[] budgets) {
        long[] results = new long[n];

        for (int i = 0; i < n; i++) {
            long budget = budgets[i];
            long bouquetSum = -1;

            for (int firstPower = 60; firstPower >= 0; firstPower--) {
                long firstValue = 1L << firstPower;
                if (firstValue > budget) {
                    continue;
                }

                long remainingBudget = budget - firstValue;

                for (int secondPower = firstPower - 1; secondPower >= 0; secondPower--) {
                    long secondValue = 1L << secondPower;
                    if (secondValue > remainingBudget) {
                        continue;
                    }

                    long remainingBudgetAfterSecond = remainingBudget - secondValue;

                    for (int thirdPower = secondPower - 1; thirdPower >= 0; thirdPower--) {
                        long thirdValue = 1L << thirdPower;
                        if (thirdValue <= remainingBudgetAfterSecond) {
                            bouquetSum = firstValue + secondValue + thirdValue;
                            break;
                        }
                    }

                    if (bouquetSum != -1) {
                        break;
                    }
                }

                if (bouquetSum != -1) {
                    break;
                }
            }

            results[i] = bouquetSum;
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] budgets = new long[n];
        for (int i = 0; i < n; i++) {
            budgets[i] = in.nextLong();
        }
        in.close();

        long[] results = solveFlowerProblem(n, budgets);

        for (long result : results) {
            System.out.println(result);
        }
    }
}
