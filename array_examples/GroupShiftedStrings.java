package array_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupShiftedStrings {
    public static void main(String[] args) {
        groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
    }

    // maintain map
    // create key --> that captures diff between letters of string
    // (charArr[i] - charArr[i - 1])
    // (charArr[i] - charArr[i - 1]) - 'a' --> to base it to (a to z)
    // ((charArr[i] - charArr[i - 1]) - 'a') % 26  ---> to wrap around
    // eg. "az", "ba" -> they fall in same group --> wrapped
    // TC -> O(N * K) 
    public static List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> ans = new HashMap<>();
        for (String str : strings) {
            if (str.length() == 1) {
                if (!ans.containsKey("1")) ans.put("1", new ArrayList());
                ans.get("1").add(str);
                continue;
            }
            char[] charArr = str.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < charArr.length; i++) {
                int diff = (charArr[i] - charArr[i - 1] - 'a') % 26;
                sb = sb.append(diff);
                sb = sb.append("#");
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}

