package recursion;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        List<List<Integer>> triangle1 = p.get(3);
        System.out.println(triangle1);
        List<List<Integer>> triangle2 = p.get(6);
        System.out.println(triangle2);

    }

    public List<List<Integer>> get(int size) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (size == 0) return triangle;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < size; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>();

            curr.add(1);

            for (int j = 1; j < i; j++) {
                curr.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            curr.add(1);
            triangle.add(curr);
        }

        return triangle;
    }
}
