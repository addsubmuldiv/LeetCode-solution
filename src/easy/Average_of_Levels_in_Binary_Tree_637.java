package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Double> averageOfLevels_DFS(TreeNode root) {
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

    /**
     * 此题的BFS解法，使用两个队列，一开始先把根节点加入到队列中，通过判断队列非空作为控制循环条件，下一层的节点用temp
     * 这个队列来存储，在循环快完的时候把queue再设置为temp，这样如果新一层都是null，temp就为空，queue也就为空，
     * 就能退出循环了，每一层的数字累加到sum里，然后用count来累计节点个数。每层循环快完，把sum/count就得到那一层的均值
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels_BFS(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            long sum=0,count=0;             //sum和count的值在上次循环使用完以后要重新初始化为0
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode n=queue.remove();  //每次从队列里面取出一个节点，把它的值加到sum里面，累计count，
                sum+=n.val;                 //再看它的左右子节点是否为空，不为空就加到temp中
                count++;                    //对queue里面的每一个节点重复上面两行操作，queue里的节点每次都是一层的节点
                if(n.left!=null)
                    temp.add(n.left);
                if(n.right!=null)
                    temp.add(n.right);
            }
            queue=temp;
            res.add(sum*1.0/count);
        }
        return res;
    }
}
