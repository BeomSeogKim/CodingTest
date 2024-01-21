package leet.top_interview_150._03_Binary_Tree_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _01_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList(){{
            offer(root);
        }};
        List<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()){
            int levelLength = queue.size();

            for(int i = 0; i < levelLength; ++i){
                TreeNode node = queue.poll();
                if (i == levelLength - 1){
                    answer.add(node.val);
                }

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return answer;

    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


