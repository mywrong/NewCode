package org.newcode.binarytree;

import org.newcode.common.TreeNode;

/**
 * @program: <a href="https://www.nowcoder.com/practice/d9820119321945f588ed6a26f0a6991f?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 3.所有节点的值都是唯一的。
 * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 思路：
 * 若p,q都比当前结点的值小，说明最近公共祖先结点在当前结点的左子树上，继续检查左子树；
 * 若p,q都比当前结点的值大，说明最近公共祖先结点在当前结点的右子树上，继续检查右子树；
 * 若p,q中一个比当前结点的值大，另一个比当前结点的值小，则当前结点为最近公共祖先结点
 */
public class BM37LowestCommonAncestor {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        TreeNode r = root;
        while (r != null) {
            if (p < r.val && q < r.val) {
                r = r.left;
            } else if (p > r.val && q > r.val) {
                r = r.right;
            }else{
                break;
            }
        }
        return r.val;
    }
}
