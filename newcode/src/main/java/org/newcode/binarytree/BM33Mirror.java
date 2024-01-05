package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class BM33Mirror {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null) {
            return null;
        }
        TreeNode left = Mirror(pRoot.right);
        TreeNode right = Mirror(pRoot.left);
        pRoot.left = left;
        pRoot.right = right;
        return pRoot;
    }
}
