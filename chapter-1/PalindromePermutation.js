// Given a string, write a function to check if it is a permutation of a palindrome. The palindrome does not need to be limited to just dictionary words.
//hint: A string is a permutation of a palindrome if it can be rearranged to form a palindrome.
// A string can form a palindrome if at most one character has an odd frequency.

// Use a hash table to count how many times each character appears. 
// Iterate through the hash table and ensure that no more than one character has an odd count.

function isPermutationOfPalindrome(str) {
    //normalize input 
    const isAlphabetic = (char) => char >= 'a' && char <= 'z';
    str = str.toLowerCase();
    const charCount = {};

    //count char frequencies
    for (let char of str) {
        if (isAlphabetic(char)) {
            charCount[char] = (charCount[char] || 0) + 1;
        }
    }

    //check for odd counts
    let oddCount = 0;
    for (let count of Object.values(charCount)) {
        if (count % 2 !== 0) oddCount++;
        if (oddCount > 1) return false;
    }

    return true;

}


//optimized solution using a set 
function isPermutationOfPalindrome(str) {
    //normalize input
    const isAlphabetic = (char) = char >= 'a' && char <= 'z';
    str = str.toLowerCase();

    //use a set to track chars with odd frequencies 
    const oddSet = new Set();
    for (let char of str) {
        if (isAlphabetic(char)) {
            if (oddSet.has(char)) {
                oddSet.delete(char); //even frequency, remove
            } else {
                oddSet.add(char); //odd freuency, add
            }
        }
    }

    //check result 
    return oddSet.size <= 1;
}