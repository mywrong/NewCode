package code;

/**
 * @link: <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 思路：
 * 面积公式： area= min(height[i],height[j]) × |i-j|
 * 1. 短板向内移动，area 可能增长也可能缩短
 * 2. 长板向内移动，area 一定变小
 * 所以一定是向内移动长板，移动过程中比较最大面积
 */
public class L11MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] > height[right]) {
                res = Math.max(res, height[right] * (right - left));
                right--;
            } else {
                res = Math.max(res, height[left] * (right - left));
                left++;
            }
        }
        return res;
    }
}
