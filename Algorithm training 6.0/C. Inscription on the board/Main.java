import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] table = new char[n][n];
        for (int i = 0; i < n; i++) {
            table[i] = scanner.nextLine().toCharArray();
        }

        int[] outerRect = getOuterRectangle(table, n);
        if (outerRect == null) {
            System.out.println("X");
            return;
        }

        if (isI(outerRect, table, n)) {
            System.out.println("I");
        } else if (isO(outerRect, table, n)) {
            System.out.println("O");
        } else if (isC(outerRect, table, n)) {
            System.out.println("C");
        } else if (isL(outerRect, table, n)) {
            System.out.println("L");
        } else if (isH(outerRect, table, n)) {
            System.out.println("H");
        } else if (isP(outerRect, table, n)) {
            System.out.println("P");
        } else {
            System.out.println("X");
        }
    }

    private static int[] getOuterRectangle(char[][] table, int n) {
        int x1 = n, y1 = n, x2 = -1, y2 = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == '#') {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        return (x1 <= x2 && y1 <= y2) ? new int[] { x1, y1, x2, y2 } : null;
    }

    private static boolean isI(int[] rect, char[][] table, int n) {
        for (int i = rect[0]; i <= rect[2]; i++) {
            for (int j = rect[1]; j <= rect[3]; j++) {
                if (table[i][j] != '#')
                    return false;
            }
        }
        return true;
    }

    private static boolean isO(int[] rect, char[][] table, int n) {
        for (int i = rect[0]; i <= rect[2]; i++) {
            if (table[i][rect[1]] != '#' || table[i][rect[3]] != '#') {
                return false;
            }
        }
        for (int j = rect[1]; j <= rect[3]; j++) {
            if (table[rect[0]][j] != '#' || table[rect[2]][j] != '#') {
                return false;
            }
        }

        for (int i = rect[0] + 1; i < rect[2]; i++) {
            for (int j = rect[1] + 1; j < rect[3]; j++) {
                if (table[i][j] == '.') {
                    int x3 = i, y3 = j;
                    int x4 = i, y4 = j;
                    while (x4 < rect[2] && table[x4][j] == '.')
                        x4++;
                    while (y4 < rect[3] && table[i][y4] == '.')
                        y4++;
                    x4--;
                    y4--;

                    return isRectangleOff(x3, y3, x4, y4, table);
                }
            }
        }
        return false;
    }

    private static boolean isRectangleOff(int x1, int y1, int x2, int y2, char[][] table) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (table[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isC(int[] rect, char[][] table, int n) {

        return hasInnerRectangle(rect, table, n, true, false);
    }

    private static boolean isL(int[] rect, char[][] table, int n) {

        return hasInnerRectangle(rect, table, n, true, true);
    }

    private static boolean isH(int[] rect, char[][] table, int n) {
        int mid = (rect[1] + rect[3]) / 2;
        boolean leftPart = hasInnerRectangle(new int[] { rect[0], rect[1], rect[2], mid }, table, n, false, false);
        boolean rightPart = hasInnerRectangle(new int[] { rect[0], mid + 1, rect[2], rect[3] }, table, n, false, false);
        return leftPart && rightPart;
    }

    private static boolean isP(int[] rect, char[][] table, int n) {
        int mid = (rect[0] + rect[2]) / 2;
        boolean topPart = hasInnerRectangle(new int[] { rect[0], rect[1], mid, rect[3] }, table, n, true, false);
        boolean bottomPart = hasInnerRectangle(new int[] { mid + 1, rect[1], rect[2], rect[3] }, table, n, true, true);
        return topPart && bottomPart;
    }

    private static boolean hasInnerRectangle(int[] rect, char[][] table, int n, boolean rightEdge, boolean topEdge) {
        for (int i = rect[0] + 1; i < rect[2]; i++) {
            for (int j = rect[1] + 1; j < rect[3]; j++) {
                if (table[i][j] == '.') {
                    int x3 = i, y3 = j;
                    int x4 = i, y4 = j;
                    while (x4 < rect[2] && table[x4][j] == '.')
                        x4++;
                    while (y4 < rect[3] && table[i][y4] == '.')
                        y4++;
                    x4--;
                    y4--;

                    if ((rightEdge && y4 == rect[3]) || (topEdge && x4 == rect[2])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
