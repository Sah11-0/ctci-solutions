//Given two strings, write a method to decide if one is a permutation of the other (two words with same character counts).

//solution 1 - sort strings
String sort(String s) {
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
}

boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    return sort(s).equals(sort(t));
}

//solution 2 - optimized, check if identical character counts
boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    int[] letters = new int[128];

    char[] s_array = s.toCharArray();
    for (char c : s_array) {
        letters[c]++;
    }

    for (int i = 0; i < t.length(); i++) {
        int c = (int) t.charAt(i);
        letters[c]--;
        if (letters[c] < 0) {
            return false;
        }
    }

    return true;
}

//solution 3 - hash map 
boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    HashMap<Character, Integer> charCount = new HashMap<>();

    for (char c : s.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1;)
    }

    for (char c : t.toCharArray()) {
        return false;
    }

    charCount.put(c, charCount.get(c) - 1);
    if (charCount.get(c) == 0) {
        charCount.remove(c);
    }

    return charCount.isEmpty();
}

