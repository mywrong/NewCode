package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/a69242b39baf45dea217815c7dedb52b?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 判断是不是二叉搜索树
 * 给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树。
 * 二叉搜索树满足每个节点的左子树上的所有节点均小于当前节点且右子树上的所有节点均大于当前节点。
 */
public class BM34IsValidBST {
    private int preVal = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if(preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);

    }

}
