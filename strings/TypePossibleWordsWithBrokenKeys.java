package strings;

import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.Collectors;

public class TypePossibleWordsWithBrokenKeys {
    public static void main(String[] args) {
        TypePossibleWordsWithBrokenKeys t = new TypePossibleWordsWithBrokenKeys();
        System.out.println(t.possibleWordWithBrokenKeys("Hi ! hello hey", new char[]{'h', 'i', 'e', 'l', 'y'}));
        System.out.println(t.possibleWordWithBrokenKeys("2 + 5 = 7", new char[]{}));
    }

    public int possibleWordWithBrokenKeys(String text, char[] letters) {
        Set<Character> allowedLetters = new String(letters).chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            Set<Character> wordSet = word
                    .trim()
                    .toLowerCase()
                    .chars()
                    .mapToObj(c -> (char) c)
                    .filter(Character::isAlphabetic)
                    .collect(Collectors.toSet());

            if (allowedLetters.containsAll(wordSet)) {
                count++;
            }
        }
        return count;
    }
}
