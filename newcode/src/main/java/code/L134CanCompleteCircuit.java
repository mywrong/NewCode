package code;

/**
 * @link: <a href="https://leetcode.cn/problems/gas-station/solutions/488357/jia-you-zhan-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description: 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * d[i][j] 空车从 i 到 j 后剩余的油量，要找到 d[i][i] >= 0 的 i。
 *
 * 思路：
 * 若 A 不能到达 C，则 A 到 C 之间的任意一点都到达不了 C。也就是从 A 和 C 之间任意一点出发，行驶最远不会超过 C。
 * 因此当从 A 出发最远只能行驶到 B 时，下次判断应该从 B + 1 点出发。
 */
public class L134CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumGas = 0, sumCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas < sumCost) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i += cnt + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        L134CanCompleteCircuit l134CanCompleteCircuit = new L134CanCompleteCircuit();
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(l134CanCompleteCircuit.canCompleteCircuit(gas, cost));
    }
}
