
// https://leetcode.com/problems/intersection-of-two-arrays/description/?envType=problem-list-v2&envId=hash-table
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] arrgs) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] res1 = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res1));

        int[] nums3 = { 4, 9, 5 };
        int[] nums4 = { 9, 4, 9, 8, 4 };
        int[] res2 = intersection(nums3, nums4);
        System.out.println(Arrays.toString(res2));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int elem : nums1) {
            set.add(elem);
        }

        for (int elem : nums2) {
            if (set.contains(elem) && !list.contains(elem)) {
                list.add(elem);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
