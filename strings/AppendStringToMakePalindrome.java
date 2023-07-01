package strings;

public class AppendStringToMakePalindrome {
    public static void main(String[] args) {
        AppendStringToMakePalindrome a = new AppendStringToMakePalindrome();
        System.out.println(a.appendStringToMakePalindrome("abcdc"));
        System.out.println(a.appendStringToMakePalindrome("abc"));
        System.out.println(a.appendStringToMakePalindrome("a"));
    }

    public String appendStringToMakePalindrome(String input) {
        String reverse = new StringBuilder(input).reverse().toString();

        if (input.length() <= 1) return input;

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.endsWith(reverse.substring(0, i))) {
                return input + reverse.substring(i);
            }
        }
        return "";
    }
}
