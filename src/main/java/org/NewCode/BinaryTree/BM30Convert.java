package org.NewCode.BinaryTree;

import org.NewCode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: <a href="https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 */
public class BM30Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> headAndTail = inOrder(pRootOfTree);
        return headAndTail.get(0);
    }

    private List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> left = null;
        List<TreeNode> right = null;
        if (root.left != null) {
            left = inOrder(root.left);
        }
        if (root.right != null) {
            right = inOrder(root.right);
        }
        if (left != null) {
            left.get(1).right = root;
        }
        if (right != null) {
            right.get(0).left = root;
        }
        root.left = left == null ? null : left.get(1);
        root.right = right == null ? null : right.get(0);
        return new ArrayList<>(Arrays.asList(left == null ? root : left.get(0), right == null ? root : right.get(1)));
    }
}
