package strings;

import java.util.Scanner;

class CountSubstringThatStartAndEndWith1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases > 0) {
            int size = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            System.out.println(size + "-" + str);
            System.out.println(countSubstringThatStartAndEndWith1(str));
            testCases--;
        }
    }

    private static int countSubstringThatStartAndEndWith1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (str.substring(i, j+1).startsWith("1") && str.substring(i, j+1).endsWith("1")) {
                    count++;
                }
            }
        }
        return count;
    }
}

