package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 二叉树的最大深度
 **/
public class BM28MaxDepth {
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
