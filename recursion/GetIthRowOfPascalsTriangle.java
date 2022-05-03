package recursion;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;


public class GetIthRowOfPascalsTriangle {
    public static void main(String[] args) {
        GetIthRowOfPascalsTriangle p = new GetIthRowOfPascalsTriangle();
        List<Integer> pascalRow4 = p.generateRow(3);
        ArrayUtil.print(pascalRow4);
        List<Integer> pascalRow7 = p.generateRow(6);
        ArrayUtil.print(pascalRow7);

        List<Integer> pascalRow4e = p.generateRowEfficient(3);
        ArrayUtil.print(pascalRow4e);
        List<Integer> pascalRow7e = p.generateRowEfficient(6);
        ArrayUtil.print(pascalRow7e);

        List<Integer> pascalRow4ee = p.generateRowEvenMoreEfficient(3);
        ArrayUtil.print(pascalRow4ee);
        List<Integer> pascalRow7ee = p.generateRowEvenMoreEfficient(6);
        ArrayUtil.print(pascalRow7ee);

    }

    //brute force
    public List<Integer> generateRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }

        return ans;
    }

    private int getNum(int rowIndex, int colIndex) {
        if (rowIndex == 0 || colIndex == 0 || rowIndex == colIndex) {
            return 1;
        }

        return getNum(rowIndex - 1, colIndex - 1) + getNum(rowIndex - 1, colIndex);
    }

    //DP
    public List<Integer> generateRowEfficient(int rowIndex) {
        List<Integer> curr = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            curr = new ArrayList<>();
            curr.add(1);

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
        }
        return prev;
    }

    //memory efficient DP
    public List<Integer> generateRowEvenMoreEfficient(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
}
