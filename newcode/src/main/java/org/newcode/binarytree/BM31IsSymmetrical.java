package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 对称的二叉树
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 */
public class BM31IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return true;
        }
        return isSimilar(pRoot.left, pRoot.right);
    }

    private boolean isSimilar(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSimilar(a.left, b.right) && isSimilar(a.right, b.left);
    }
}
