// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer;
        int l = nums1.length + nums2.length;
        boolean flag = false;
        if (l % 2 == 0) {
            flag = true;
        }
        l = l / 2 + 1;

        int[] arr = new int[l];

        int n1 = 0;
        int n2 = 0;
        int tec = 0;
        for (int i = 0; i < l; i++) {
            if (n1 >= nums1.length || n2 >= nums2.length) {
                break;
            }
            if (nums1[n1] < nums2[n2]) {
                arr[i] = nums1[n1];
                n1++;
            } else {
                arr[i] = nums2[n2];
                n2++;
            }
            tec = i;
        }
        if (tec == 0 && (nums1.length == 0 || nums2.length == 0)) tec--;
        tec++;

        for (int i = n1; i < nums1.length && tec < l; i++) {
            arr[tec] = nums1[i];
            tec++;
        }
        for (int i = n2; i < nums2.length && tec < l; i++) {
            arr[tec] = nums2[i];
            tec++;
        }

        if (flag == true) {
            answer = (arr[arr.length - 1] + arr[arr.length - 2]) / 2.0;
        } else {
            answer = arr[arr.length - 1];
        }

        return answer;
    }
}
