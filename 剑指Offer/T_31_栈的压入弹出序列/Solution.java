package T_31_栈的压入弹出序列;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA == null || popA == null || popA.length ==0 || pushA.length==0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int lastPushIdx = 0;
        for (int i = 0; i < popA.length; i++) {

            while ((stack.empty() ||popA[i] != stack.peek())&& lastPushIdx < pushA.length ) {
                stack.push(pushA[lastPushIdx]);
                lastPushIdx++;
            }

            if (popA[i] != stack.peek()) {
                break;
            }

            stack.pop();

        }

        if (lastPushIdx == pushA.length && stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushA = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,3,5,1,2};
        System.out.println(s.IsPopOrder(pushA, pop));
    }
}
