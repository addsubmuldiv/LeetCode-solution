package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 11:39 2017/11/6
 * @Modified_by:
 */
public class Next_Greater_Element_I_496 {
    /**
     * 遍历第二个数组，也就是第一个数组的父集合，每次判断栈是否为空，
     * 为空则把当前数字入栈；如果不为空且栈顶元素小于遍历到的数字，那么把
     * 栈顶数字作为键，当前数字为值，放入哈希表，这样子，哈希表里面保存的就是
     * 能够找到最邻近大数的那些数字和他们的最邻近大数的键值对，最后再对需要找最邻近大数的
     * 第一个数组进行遍历，使用getOrDefault()方法，能找到最邻近大数则返回最邻近大数，否则返回-1
     * 问题得解
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            //getOrDefault获取键对应的值或者返回一个默认值
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
