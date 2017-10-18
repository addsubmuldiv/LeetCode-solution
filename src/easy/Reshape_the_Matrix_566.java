package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:42 2017/10/19
 * @Modified_by:
 */

/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.
 */


public class Reshape_the_Matrix_566 {
    /**
     * 申请新矩阵，使用队列把遍历完的原矩阵保存下来，然后再从用队列把新矩阵填满
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
    /**
     * 这里是自己写的，居然忘记了可以使用队列……或者应该说是完全没有这个意识……
     */
//    public int[][] matrixReshape(int[][] nums, int r, int c) {
//        int allNeed=r*c;
//        int allHave=nums[0].length*nums.length;
//        if(allNeed>allHave)
//            return nums;
//        int[][] res=new int[r][c];
//        int[] buf=new int[allNeed];
//        int count=0;
//        for(int i=0;i<nums.length;i++) {
//            for(int j=0;j<nums[0].length;j++) {
//                buf[count++]=nums[i][j];
//            }
//        }
//        count=0;
//        for(int i=0;i<res.length;i++) {
//            for(int j=0;j<res[0].length;j++) {
//                res[i][j]=buf[count++];
//            }
//        }
//        return res;
//    }
}
