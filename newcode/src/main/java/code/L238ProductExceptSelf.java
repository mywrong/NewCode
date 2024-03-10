package code;

/**
 * @link: <a href="https://leetcode.cn/problems/product-of-array-except-self/submissions/509291816/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description:
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 思路：
 * 分别记录前缀乘积和后缀乘积，ans[i] 等于前缀积×后缀积
 */
public class L238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prev = new int[n + 2];
        int[] post = new int[n + 2];
        prev[0] = 1;
        post[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            prev[i] = prev[i - 1] * nums[i - 1];
        }
        for (int i = n; i > 0; i--) {
            post[i] = post[i + 1] * nums[i - 1];
        }
        for(int i=0;i<n;i++){
            ans[i] = prev[i] * post[i+2];
        }
        return ans;
    }
}
