package org.newcode.binarytree;

import org.newcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: <a href="https://www.nowcoder.com/practice/8daa4dff9e36409abba2adbe413d6fae?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 判断是否为完全二叉树
 * 给定一个二叉树，确定他是否是一个完全二叉树。
 * 完全二叉树的定义：若二叉树的深度为 h，除第 h 层外，其它各层的结点数都达到最大个数，第 h 层所有的叶子结点都连续集中在最左边，这就是完全二叉树。（第 h 层可能包含 [1~2h] 个节点）
 */

public class BM35IsCompleteTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        System.out.println(isCompleteTree(root));
    }
    public static boolean isCompleteTree(TreeNode root) {
        // write code here
        if(root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>(); //!!! 以前使用 LinedBlockingQueue 会报错，LinedBlockingQueue 不能接受 null
        queue.add(root);
        boolean shoudNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node == null){
                    shoudNull = true;
                    continue;
                }
                if(shoudNull) {
                    return false;
                }else{
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

        }
        return true;
    }
}
