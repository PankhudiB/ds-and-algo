package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Lapindromes {
    static final int MAX_CHAR = 26;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while (testCases-- > 0) {
            String str = reader.readLine();
            System.out.println(str + " -- " + isLapindrome(str));
            System.out.println(str + " -- " + isLapindromeUsingArray(str));
            System.out.println(str + " -- " + isLapindromeUsingArrayMemoryEfficient(str));
        }
    }

    private static boolean isLapindrome(String str) {
        Map<Character, Integer> f1;
        Map<Character, Integer> f2;
        int mid = str.length() / 2;
        if (str.length() % 2 == 0) {
            f1 = frequency(str.substring(0, mid));
            f2 = frequency(str.substring(mid));
        } else {
            f1 = frequency(str.substring(0, mid));
            f2 = frequency(str.substring(mid + 1));
        }
        return f1.equals(f2);
    }

    private static Map<Character, Integer> frequency(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            if (map.containsKey(c)) {
                int curr = map.get(c);
                map.put(c, curr + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private static boolean isLapindromeUsingArray(String str) {
        int[] f1 = new int[MAX_CHAR];
        int[] f2 = new int[MAX_CHAR];
        int n = str.length();
        if (n == 1)
            return true;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            f1[str.charAt(i) - 'a']++;
            f2[str.charAt(j) - 'a']++;
        }
        for (int i = 0; i < MAX_CHAR; i++) {
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }

    private static boolean isLapindromeUsingArrayMemoryEfficient(String str) {
        int[] frequency1 = new int[MAX_CHAR];
        int n = str.length();
        if (n == 1)
            return true;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            frequency1[str.charAt(i) - 'a']++;
            frequency1[str.charAt(j) - 'a']--;
        }
        for (int i = 0; i < MAX_CHAR; i++) {
            if (frequency1[i] != 0) return false;
        }
        return true;
    }
}

