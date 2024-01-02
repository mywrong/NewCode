package org.NewCode.BinaryTree;

import org.NewCode.common.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: <a href="https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=295&tqId=644&ru=%2Fpractice%2F91b69814117f4e8097390d107d2efbe0&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 二叉树的层序遍历
 **/
public class BM26LevelOrder {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        if(root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode r = queue.poll();
                tmp.add(r.val);
                if(r.left != null) {
                    queue.add(r.left);
                }
                if(r.right != null) {
                    queue.add(r.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


}