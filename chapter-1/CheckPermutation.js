//Given two strings, write a method to decide if one is a permutation of the other (two words with same character counts).

function isPermutation(str1, str2) {
    if (str1.length !== str2.length) return false;

    let count = {};

    for (let char of str1) {
        count[char] = (count[char] || 0) + 1;
    }

    for (let char of str2) {
        if (!count[char]) {
            return false;
        }
        count[char]--
    }

    return true;
}
