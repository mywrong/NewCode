package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/7298353c24cc42e3bd5f0e0bd3d1d759?tpId=295&tqId=1025038&ru=%2Fpractice%2Ff23604257af94d939848729b1a5cda08&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 合并二叉树
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 */
public class BM32MergeTrees {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
