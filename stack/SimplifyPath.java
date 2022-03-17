package stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/b/c/.././././//d"));
        System.out.println(simplifyPath("/a/./b/"));
    }

    public static String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals(".") || token.equals(""))
                continue;
            else if (token.equals("..")) {
                if (!stack.isEmpty()) stack.pop();

            } else {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String directory : stack) {
            sb.append("/");
            sb.append(directory);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
