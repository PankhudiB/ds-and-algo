package stack;

import java.util.Scanner;
import java.util.Stack;

public class CdAndPwd {

    public static final String PWD = "pwd";
    public static final String CD = "cd";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            Stack<String> stack = new Stack<>();
            int noOfCommands = sc.nextInt();
            String command;
            while (noOfCommands-- != 0) {
                command = sc.next();
                if (command.equals(PWD)) {
                    pwd(stack);
                } else if (command.equals(CD)) {
                    command = sc.next();
                    cd(stack, command);
                }
            }
        }
    }

    private static void cd(Stack<String> stack, String command) {
        String[] commands = command.split("/");
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("")) {
                stack.clear();
            } else if (commands[i].equals("..")) {
                stack.pop();
            } else {
                stack.push(commands[i]);
            }
        }
    }

    private static void pwd(Stack<String> stack) {
        System.out.print("/");
        for (String element : stack) {
            System.out.print(element + "/");
        }
        System.out.println();
    }
}
