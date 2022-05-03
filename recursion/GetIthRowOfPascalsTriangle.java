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

}
