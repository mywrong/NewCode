package code;

/**
 * @link: <a href="https://leetcode.cn/problems/jump-game-ii/submissions/508952884/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description:
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 思路：
 * 遍历数组，维护一个边界 end ，当 i == end + 1 时, 最小跳跃次数 +1，end 变更为到达当前位置前所能达到的最远位置。
 */
public class L45CanJum2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (i == end + 1) {
                end = maxPos;
                res++;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        L45CanJum2 l45CanJum2 = new L45CanJum2();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(l45CanJum2.jump(nums));
    }
}
