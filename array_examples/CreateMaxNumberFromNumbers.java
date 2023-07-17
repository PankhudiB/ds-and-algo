package array_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CreateMaxNumberFromNumbers {
    public static void main(String[] args) {
        CreateMaxNumberFromNumbers c = new CreateMaxNumberFromNumbers();
        System.out.println(c.maxNumberPossible(new String[]{"34", "7", "80", "81", "6"})); // 81807634
        System.out.println(c.maxNumberPossible(new String[]{"34", "3"})); // 343
        System.out.println(c.maxNumberPossible(new String[]{"34", "31"})); // 343

//        7 , 81 -> 81
//        9 , 81 -> 9
//        8 , 81 -> 81
//
    }

    private int maxNumberPossible(String[] numsStr) {

        List<String> nums = Arrays.stream(numsStr).sorted((o1, o2) -> {
            int dig1 = o1.length();
            int dig2 = o2.length();
            int num1 = Integer.parseInt(o1);
            int num2 = Integer.parseInt(o2);
            int diff = Math.abs(dig1 - dig2);
            int mul = (int) Math.pow(10, diff);

            if (dig1 == dig2) {
                return Integer.compare(num2, num1);
            } else if (dig1 < dig2) {
                int temp1 = num1 * mul;
                return Integer.compare(num2, temp1);
            } else {
                int temp2 = num2 * mul;
                return Integer.compare(temp2, num1);
            }
        }).toList();

        StringBuilder sb = new StringBuilder();
        nums.forEach(sb::append);
        return Integer.parseInt(sb.toString());
    }
}
