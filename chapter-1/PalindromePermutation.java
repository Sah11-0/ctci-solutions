/*  Given a string, write a function to check if it is a permutation of a palindrome. The palindrome does not need to be limited to just dictionary words.

Use a hash table to count how many times each character appears. 
Iterate through the hash table and ensure that no more than one character has an odd count. */

boolean isPermutationOfPalindrome(String phrase) {
    int [] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
}

/* Check no more than one character has odd count */
boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count : table) {
        if (count % 2 == 1) {
            if (foundOdd) {
                return false;
            }
            foundOdd = true;
        }
    }
    return true;
}

/* Map each character to a number. Case insensitive. Non-letters map to -1 */
int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
        return val - a;
    }
    return -1;
}

/* Count times each character appears */
int[] buildCharFrequencyTable(String phrase) {
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : phrase.toCharArray()) {
        int x = getCharNumber(c);
        if (x != -1) {
            table[x]++;
        }
    }
    return table;
}