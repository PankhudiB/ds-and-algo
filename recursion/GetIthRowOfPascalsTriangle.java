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

    }

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
}
