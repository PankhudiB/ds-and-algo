package array_examples;

import util.ArrayUtil;

import java.util.Stack;

class ReplaceElements_GreatestElementonRightSide {
    public static void main(String[] args) {
        ArrayUtil.print(replaceElements(new int[]{17, 18, 5, 4, 6, 1}));
        ArrayUtil.print(replaceElements(new int[]{1, 2, 3, 4}));
        ArrayUtil.print(replaceElements(new int[]{4, 3, 2, 1}));
    }

    public static int[] replaceElements(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for (int i = arr.length - 1; i > 0; i--) {
            int top = s.peek();
            if (arr[i] > top) {
                s.push(arr[i]);
            } else {
                s.push(top);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.pop();
        }
        return arr;
    }
}

