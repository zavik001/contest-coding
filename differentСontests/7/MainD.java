import java.util.Scanner;

public class MainD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        in.close();

        long lcmXYZ = lcm(lcm(x, y), z);
        long lcmXY = lcm(x, y);
        long lcmXZ = lcm(x, z);
        long lcmYZ = lcm(y, z);

        long minXYZ = Long.MAX_VALUE;
        long minXY = Long.MAX_VALUE;
        long minXZ = Long.MAX_VALUE;
        long minYZ = Long.MAX_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long minZ = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] % lcmXYZ == 0) {
                minXYZ = 0;
            } else {
                minXYZ = Math.min(minXYZ, lcmXYZ - arr[i] % lcmXYZ);
            }

            if (arr[i] % lcmXY == 0) {
                minXY = 0;
            } else {
                minXY = Math.min(minXY, lcmXY - arr[i] % lcmXY);
            }

            if (arr[i] % lcmXZ == 0) {
                minXZ = 0;
            } else {
                minXZ = Math.min(minXZ, lcmXZ - arr[i] % lcmXZ);
            }

            if (arr[i] % lcmYZ == 0) {
                minYZ = 0;
            } else {
                minYZ = Math.min(minYZ, lcmYZ - arr[i] % lcmYZ);
            }

            if (arr[i] % x == 0) {
                minX = 0;
            } else {
                minX = Math.min(minX, x - arr[i] % x);
            }

            if (arr[i] % y == 0) {
                minY = 0;
            } else {
                minY = Math.min(minY, y - arr[i] % y);
            }

            if (arr[i] % z == 0) {
                minZ = 0;
            } else {
                minZ = Math.min(minZ, z - arr[i] % z);
            }
        }

        long resultXY = minXY + minZ;
        long resultXZ = minXZ + minY;
        long resultYZ = minYZ + minX;

        long finalResult = Math.min(minXYZ,
                Math.min(resultXY, Math.min(resultXZ, Math.min(resultYZ, minX + minY + minZ))));

        System.out.println(finalResult);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
