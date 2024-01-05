package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 判断是不是平衡二叉树
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 */
public class BM36IsBalancedTree {
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return true;
        }
        return IsBalanced_Solution(pRoot.left) && IsBalanced_Solution(pRoot.right) && Math.abs(getDepth(pRoot.left) - getDepth(pRoot.right)) <= 1;

    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
