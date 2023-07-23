package array_examples;

//Sliding window ~~~~~~
public class LongestSubstringAchievableWith1Flip {
    public static void main(String[] args) {
        LongestSubstringAchievableWith1Flip s = new LongestSubstringAchievableWith1Flip();
        System.out.println(s.longestSubstringAchievableWith1Flip("10011"));
    }

    //    1101101111
//        1234511111
// noOfZ  0010011
//    max=50
    private int longestSubstringAchievableWith1Flip(String s) {
        int left = 0;
        int currNoOfZeros = 0;
        int ans = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                ans++;
            } else if (s.charAt(right) == '0') {
                currNoOfZeros++;
                ans++;
                if (currNoOfZeros > 1) {
                    currNoOfZeros = 1;
                    ans--;
                    max = Math.max(max, ans);
                    ans = 1;
                }
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}
