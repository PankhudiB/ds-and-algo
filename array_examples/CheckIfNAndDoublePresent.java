package array_examples;

import java.util.HashSet;

class CheckIfNAndDoublePresent {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 5, 2, 3}));
        System.out.println(checkIfExist(new int[]{2, 5, 3, 10}));
    }

    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<Integer>(arr.length);
        for (int elem : arr) {
            if (hs.contains(elem * 2) || (elem % 2 == 0 && hs.contains(elem / 2))) {
                return true;
            }
            hs.add(elem);
        }
        return false;
    }
}

