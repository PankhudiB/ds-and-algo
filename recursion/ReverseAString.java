package recursion;

public class ReverseAString {
    public static void main(String[] args) {
        ReverseAString r = new ReverseAString();
        r.reverseString(new char[]{'a', 'b', 'c', 'd'});
    }

    void reverseString(char[] str) {
        helper(0, str);
    }

    void helper(int index, char[] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index] + " ");
    }

    void twoPointerApproach(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
}
