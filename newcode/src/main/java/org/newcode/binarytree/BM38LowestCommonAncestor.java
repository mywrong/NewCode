package org.newcode.binarytree;

import org.newcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @description: 在二叉树中找到两个节点的最近公共祖先
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * 思路：
 * 保存从根节点到p和q的路径，然后找到最后一个相同的节点即为最近公共祖先
 */
public class BM38LowestCommonAncestor {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        dfs(root, p, path1);
        dfs(root, q, path2);
        int i = 0;
        while(i<path1.size() && i<path2.size() && path1.get(i) == path2.get(i)){
            i++;
        }
        return path1.get(i-1).val;
    }

    private boolean dfs(TreeNode root, int target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.val == target || dfs(root.left, target, path) || dfs(root.right, target, path)) {
            return true;
        } else {
            path.remove(path.size() - 1);
            return false;
        }
    }
}
