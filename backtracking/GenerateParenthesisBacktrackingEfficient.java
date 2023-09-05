package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesisBacktrackingEfficient {
    public static void main(String[] args) {
        GenerateParenthesisBacktrackingEfficient s = new GenerateParenthesisBacktrackingEfficient();

//        System.out.println(s.generateParenthesis(1));
        System.out.println(s.generateParenthesis(2));
//        System.out.println(s.generateParenthesis(3));
    }

    public  List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> answer, StringBuilder sb,int leftCount, int rightCount, int n){
        if (sb.length() == 2*n){
            answer.add(sb.toString());
            return;
        }

        if( leftCount < n ){
            sb.append("(");
            backtrack(answer,sb, leftCount+1,rightCount,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(leftCount > rightCount){
            sb.append(")");
            backtrack(answer,sb, leftCount,rightCount+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

