package org.newcode.dp;

/** @link: <a href="https://www.nowcoder.com/practice/c5fbf7325fbd4c0ea3d0c3ea6bc6cc79?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 *
 * @description: 你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，
 * 即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
 * 给定一个整数数组 nums ，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 *
 * 思路：
 * d[0] = 0;
 * d[1] = nums[0];
 * d[i] = max( d[i-1], d[i-2] + nums[i-1] );
 */
public class BM78Rob {
    public int rob(int[] nums) {
        // write code here
        int[] d = new int[nums.length+1];
        d[1] = nums[0];
        for(int i = 2;i<d.length;i++){
            d[i] = Math.max(d[i-1],d[i-2]+nums[i-1]);
        }
        return d[d.length-1];
    }
}
