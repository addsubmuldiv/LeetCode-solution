package easy;

/**
 * @Author: Lighters_c
 * @Discrpition: 这个题目是关于树和递归的，在碰到树的问题的时候可以适当考虑递归，另外递归要从极端条件去思考切入,时刻记住！！！
 * """""""""""""""""haskell里的模式匹配"""""""""""""""""
 * @Date: Created in 0:43 2017/10/12
 * @Modified_by:
 */

/*
问题如下：
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
Note: The merging process must start from the root nodes of both trees.

 */


public class Merge_Two_Binary_Trees_617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }
}

/**
 * 递归的思想，考虑当整棵树只有一个节点的时候，可能出现的情况，要么其中一个为空，返回另一个，要么两个都不为空，然后把
 * 两个的值加起来，因为把判断是否为空的并直接返回的语句放在前面了，就不会出现解引用空指针的情况，再处理他们的左孩子和
 * 右孩子。这里是直接在t1这棵树上做修改了。
 */






