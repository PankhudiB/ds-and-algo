package array_examples;

//Sliding window ~~~~~~
public class LongestSubstringAchievableWith1Flip {
    public static void main(String[] args) {
        LongestSubstringAchievableWith1Flip s = new LongestSubstringAchievableWith1Flip();
        System.out.println(s.longestSubstringAchievableWith1Flip("11001011"));
    }

    public int longestSubstringAchievableWith1Flip(String s) {
        int left = 0, currNoOfZeros = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') currNoOfZeros++;

            if (currNoOfZeros > 1) {
                if (s.charAt(left) == '0')
                    currNoOfZeros--;

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
