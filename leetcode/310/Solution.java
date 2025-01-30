// https://leetcode.com/problems/minimum-height-trees/submissions/1525106170/

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leavesSize = leaves.size();
            remainingNodes -= leavesSize;

            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}
