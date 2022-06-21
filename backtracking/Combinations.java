package backtracking;

import java.util.List;
import java.util.LinkedList;

public class Combinations {
    List<List<Integer>> solutions = new LinkedList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return solutions;
    }

    private void backtrack(int first, LinkedList<Integer> combinationSoFar) {
        if (combinationSoFar.size() == k) {
            solutions.add(new LinkedList(combinationSoFar));
            return;
        }

        for (int i = first; i <= n; i++) {
            combinationSoFar.addLast(i);
            backtrack(i + 1, combinationSoFar);
            combinationSoFar.removeLast();
        }
    }
}
