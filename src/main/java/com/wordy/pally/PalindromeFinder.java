package com.wordy.pally;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * A finder of palindromes in 'a man, a plan, a canal - Panama'!
 *
 * Finds top X length palindromes for a given String
 *
 */
public class PalindromeFinder {

    /**
     * Find top X length palindromes
     *
     * @param inputString string to search for palindromes
     * @param numToReturn number of top ranking palindromes to return
     * @return top X list of palindromes ordered by length
     */
    public List<Palindrome> find(String inputString, int numToReturn) {
        List<Palindrome> palindromes = new ArrayList<Palindrome>();
        char[] characters = inputString.toCharArray();

        for (int count = 2 ; count < characters.length ; count++) {
            if (isRepeatCharacterAtIndex(characters, count)) {
                Palindrome palindrome = findPalindromeFromIndex(characters, count);
                palindromes.add(palindrome);
            }
        }

        // sort results by palindrome length (largest first) and take top X (numToReturn)
        palindromes.sort((o1, o2) -> o2.length().compareTo(o1.length()));
        Comparator<Palindrome> comparator = (o1, o2) -> o2.length().compareTo(o1.length());
        return palindromes.stream().sorted(comparator).limit(numToReturn).collect(Collectors.toList());
    }



    /**
     * Use while parsing string or character arrays to flag duplicate character in a given string
     *
     * @param characters given string to find repeating letters
     * @param atIndex index of second repeating character
     * @return true if given index is repeating character
     */
    public boolean isRepeatCharacterAtIndex(char[] characters, int atIndex) {
        if (atIndex < 1 || atIndex > characters.length -1) return false;
        char currentCharacter = characters[atIndex];
        char previousCharacter = characters[atIndex -1];
        if (currentCharacter == previousCharacter) return true;
        return false;
    }


    /**
     * Return pair of matching characters at given distance from index of flagged duplicate character in given string
     *
     * @param characters character array (string) to search
     * @param fromIndex index of duplicate character
     * @param distance number of elements to search outward from flagged duplicate character
     * @return an array of matching characters (null if no matching characters found)
     */
    char[] getNextMatchingCharPair(char[] characters, int fromIndex, int distance) {
        int previousCharIndex = fromIndex -1;
        if ((previousCharIndex - distance) < 0 || (fromIndex + distance) > (characters.length - 1)) {
            return null;
        }
        char[] pair = new char[2];
        char charBefore = characters[previousCharIndex - distance];
        char charAfter = characters[fromIndex + distance];
        if (charBefore != charAfter) {
            return null;

        }
        pair[0] = charBefore;
        pair[1] = charAfter;
        return pair;

    }



    /**
     * Search outwards for palindrome text from given duplicate character index
     *
     * @param characters character array to search
     * @param fromIndex index of repeating character
     * @return string of palindrome found at given index
     */
    Palindrome findPalindromeFromIndex(char[] characters, int fromIndex) {
        int previousCharIndex = fromIndex -1;
        boolean findMatching = true;
        int iteration = 1;
        char[] firstPair = getNextMatchingCharPair(characters, fromIndex, 0);
        StringBuilder currentPalindrome = new StringBuilder().append(firstPair);
        while(findMatching) {
            char[] nextPair = getNextMatchingCharPair(characters, fromIndex, iteration);
            if (nextPair != null) {
                currentPalindrome.append(nextPair[1]);
                currentPalindrome = new StringBuilder().append(nextPair[0]).append(currentPalindrome);
                iteration++;
            } else {
                findMatching = false;
            }
        }
        Palindrome palindrome = new Palindrome(currentPalindrome.toString(), (previousCharIndex - iteration) + 1, iteration * 2);
        return palindrome;
    }

}
