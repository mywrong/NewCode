package code;

/**
 * @link: <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description:
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  思路：
 *  维护一个窗口，当窗口之和大于等于 target ，比较窗口长度，并 slow ++，当窗口之和小于 target，fast++
 */
public class L209MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int slow = 0, fast = 0;
        int sum = nums[0];
        while (fast < n) {
            if (sum < target) {
                fast++;
                if (fast < n) {
                    sum += nums[fast];
                }
            } else {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}
