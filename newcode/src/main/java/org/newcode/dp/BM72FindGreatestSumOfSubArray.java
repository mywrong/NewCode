package org.newcode.dp;

/**
 * @description: 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 *
 * 思路：
 * d[i]记录以第 i 个整数结尾的子数组的和的最大值
 * d[i-1] < 0: d[i] = array[i]
 * d[i-1]>=0: d[i] = array[i] + d[i-1]
 */
public class BM72FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        // write code here
        int res = array[0];
        int n = array.length;
        int[] d = new int[n];
        d[0] = array[0];
        for (int i = 1; i < n; i++) {
            if (d[i - 1] < 0) {
                d[i] = array[i];
            } else {
                d[i] = d[i - 1] + array[i];
            }
            res = Math.max(res, d[i]);
        }
        return res;
    }
}
