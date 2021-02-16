package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Lapindromes {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while (testCases-- > 0) {
            String str = reader.readLine();
            System.out.println(str + " -- " + isLapindrome(str));
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
}

