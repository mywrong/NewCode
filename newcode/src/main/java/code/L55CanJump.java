package code;

/**
 * @link: <a href="https://leetcode.cn/problems/jump-game/submissions/508482903/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description: 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 思路：
 * 遍历数组，记录当前能遍历到达的最大下标，退出遍历时判断最大下标是否大于等于最后一个下标
 */
public class L55CanJump {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        int i = 0;
        while (i < nums.length && i <= maxPos) {
            maxPos = Math.max(maxPos, i + nums[i]);
            i++;
        }
        return maxPos >= nums.length - 1;
    }

    public static void main(String[] args) {
        L55CanJump l55CanJump = new L55CanJump();
//        int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(l55CanJump.canJump(nums));
    }
}
