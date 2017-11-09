package easy;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 21:56 2017/11/9
 * @Modified_by:
 */

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 */


public class Maximum_Depth_of_Binary_Tree_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 深度优先遍历，递归一行解决
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


}
