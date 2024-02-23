package org.newcode.dp;

import java.util.Arrays;

/**
 * @link: <a href="https://www.nowcoder.com/practice/a5c127769dd74a63ada7bff37d9c5815?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 你是一个经验丰富的小偷，准备偷沿湖的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，
 * 即，如果偷了第一家，就不能再偷第二家，如果偷了第二家，那么就不能偷第一家和第三家。沿湖的房间组成一个闭合的圆形，即第一个房间和最后一个房间视为相邻。
 * 给定一个长度为n的整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 *
 * 思路：
 * 分情况讨论：
 * 1. 偷第一家，则不能偷最后一家：d[1] = nums[0], d[i] = Math.max(d[i-1],d[i-2]+nums[i-1]),结果为倒数第二家的值，即 d[d.length-2]
 * 2. 不偷第一家，则可以偷最后一家：d[0] = 0, d[i] = Math.max(d[i-1],d[i-2]+nums[i-1]),结果为最后一家的值，即 d[d.length-1]
 * 最后对两种情况的结果取最大值。
 *
 */
public class BM79Rob2 {
    public int rob (int[] nums) {
        // write code here
        int[] d = new int[nums.length+1];
        d[1] = nums[0];
        for(int i =2;i<d.length-1;i++){
            d[i] = Math.max(d[i-1],d[i-2]+nums[i-1]);
        }
        int res = d[d.length-2];
        Arrays.fill(d,0);
        for(int i=2;i<d.length;i++){
            d[i] = Math.max(d[i-1],d[i-2]+nums[i-1]);
        }
        return Math.max(res,d[d.length-1]);

    }
}
