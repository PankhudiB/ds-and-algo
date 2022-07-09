package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {

    public static void main(String[] args) {
        System.out.println(crackSafe(1, 2));
        System.out.println(crackSafe(2, 2));
    }

    /*
        _ _ _ _ --> N
        each element lies between [0 , k-1]

        There are K^N permutations possible
        hence -> DFS breaks at visited set --> has k^n elements

        n=2, k=2
        Start with n zeros --> 00
        At each step -> pick last n-1 chars -> 0
            From there are k possibilities [0,1]
            curr possibility -> 00 -> already seen
            curr possibility -> 01 -> mark visited
            string so far --> 001
                    -> do dfs for same -> meets break condition -> return true
                    -> else {
                            mark the curr possibility 01 -> non visited
                            remove from stringSoFar --> 001 becomes -> 00
                        }

        So on so forth..
     */
    public static String crackSafe(int n, int k) {
        int totalPermutations = (int) (Math.pow(k, n));

        System.out.println("total : " + totalPermutations);
        Set<String> visited = new HashSet<>();

        String initialPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sb = new StringBuilder(initialPwd);

        visited.add(sb.toString());

        dfs(sb, visited, n, k, totalPermutations);
        return sb.toString();
    }

    private static boolean dfs(StringBuilder sb, Set<String> visited, int n, int k, int totalPermutations) {
        if (visited.size() == totalPermutations) return true;

        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);

                if (dfs(sb, visited, n, k, totalPermutations)) {
                    return true;
                } else {
                    visited.remove(next);
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
        return false;
    }
}
