// 1.1 Implement an algorithm to determine if a string has all unique characters. What is you cannot use additional data structures?

public class uniqueCharacters {
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length; i++) {
            int charIndex = str.charAt(i);
            if (charSet[charIndex]) {
                return false;
            }
            charSet[charIndex] = true;
        }
        return true;
    }
}
