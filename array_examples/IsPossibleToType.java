package array_examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsPossibleToType {
    public static void main(String[] args) {
        System.out.println(isPossibleToType("Hello, this is CodeSignal!", new char[]{'e', 'i', 'h', 'l', 'o', 's'}));
        System.out.println(isPossibleToType("2 + 3 = 5", new char[]{}));
    }

    public static int isPossibleToType(String text, char[] allowedInput) {
        Set<Character> allowed = new HashSet<>();
        for (char c : allowedInput) {
            allowed.add(Character.toLowerCase(c));
        }

        int result = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            Set<Character> curr = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (Character.isAlphabetic(c))
                    curr.add(Character.toLowerCase(c));
            }
            if (allowed.containsAll(curr)) {
                result++;
            }
        }

        return result;
    }
}
