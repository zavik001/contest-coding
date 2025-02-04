// https://leetcode.com/problems/cut-off-trees-for-golf-event/

import java.util.*;

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        if (m == 0) return -1;
        int n = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        trees.sort((a, b) -> a[0] - b[0]);

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int totalSteps = 0;
        int currX = 0, currY = 0;

        for (int[] tree : trees) {
            int targetX = tree[1], targetY = tree[2];
            int steps = bfs(forest, currX, currY, targetX, targetY, m, n, dirs);
            if (steps == -1) return -1;
            totalSteps += steps;
            currX = targetX;
            currY = targetY;
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY, int m, int n, int[][] dirs) {
        if (startX == targetX && startY == targetY) return 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                if (x == targetX && y == targetY) return steps;

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
