package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 17:58 2017/11/7
 * @Modified_by:
 */

//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//
//        Example 1:
//        Input:
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        Output: [3, 14.5, 11]
//        Explanation:
//        The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//        Note:
//        The range of node's value is in the range of 32-bit signed integer.


public class Average_of_Levels_in_Binary_Tree_637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Integer> count=new ArrayList<>();
        ArrayList<Double> res=new ArrayList<>();
        if(root==null) {
            return null;
        }
        average(root,0,res,count);
        for(int i=0;i<res.size();i++) {
            res.set(i,res.get(i)/count.get(i));
        }
        return res;
    }

    /**
     * 这个写法使用深度优先遍历，对在递归的同时，将缓冲区以及一个记录层数的整数作为参数传入，累加每一层的节点值，
     * 以及每一层的节点数量，然后将结果计算出来，使用了深度优先遍历
     * @param t
     * @param i
     * @param sum
     * @param count
     */
    public void average(TreeNode t,int i,List<Double> sum,List<Integer> count) {
        if(t==null) {
            return;
        }
        if(i<sum.size()) {
            sum.set(i,sum.get(i)+t.val);
            count.set(i,count.get(i)+1);
        } else {
            sum.add(1.0*t.val);
            count.add(1);
        }
        average(t.left,i+1,sum,count);
        average(t.right,i+1,sum,count);
    }
}
