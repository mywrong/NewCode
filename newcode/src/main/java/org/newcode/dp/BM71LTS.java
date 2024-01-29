package org.newcode.dp;

/**
 * @description: 给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
 * 所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列。
 * 我们定义一个序列是 严格上升 的，当且仅当该序列不存在两个下标 i 和 j 满足 i<j，且 arri >= arrj
 * 时间O(n^2) 空间O(n)
 *
 * 思路：
 * d[i] 记录以第 i 个数为结尾的子序列的最大长度。
 * d[i] = max(d[j]) + 1, 0 <= j < i
 */
public class BM71LTS {
    public int LIS(int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int res = 1;
        int[] d = new int[arr.length];
        d[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            d[i] = 1;
            for (int j = i - 1; j > -1; j--) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }

            res = Math.max(res, d[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        BM71LTS s = new BM71LTS();
        System.out.println(s.LIS(new int[]{1, 2, 3, 4, 3, 5}));
    }
}
