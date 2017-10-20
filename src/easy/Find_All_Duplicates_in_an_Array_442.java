package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:02 2017/10/21
 * @Modified_by:
 */
/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

/*
找重复的数字，数字的特征刚好是1<=x<=N的，所以可以把这个数字的绝对值减1，把这个下标的数字设为负的，然后如果下一次又检测到
是个负的，说明这个下标已经被访问过了，就加到List里面
 */
public class Find_All_Duplicates_in_an_Array_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
    /*
        这里是没看题结果写了个超慢的算法
     */
//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> integers=new ArrayList<>();
//        Set<Integer> integerSet=new HashSet<>();
//        for(int i=0;i<nums.length;i++) {
//            if(integerSet.contains(nums[i]))
//                integers.add(new Integer(nums[i]));
//            else
//                integerSet.add(nums[i]);
//        }
//        return integers;
//    }
}
