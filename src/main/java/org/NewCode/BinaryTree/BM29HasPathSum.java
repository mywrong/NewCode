package org.NewCode.BinaryTree;

import org.NewCode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/508378c0823c423baa723ce448cbfd0c?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 二叉树中和为某一值的路径(一)
    给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
    1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
    2.叶子节点是指没有子节点的节点
    3.路径只能从父节点到子节点，不能从子节点到父节点
    4.总节点数目为n
 */
public class BM29HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        return (root.left == null && root.right == null && root.val == sum)
                || (root.left != null && hasPathSum(root.left, sum - root.val))
                || (root.right != null && hasPathSum(root.right, sum - root.val));
    }
}
