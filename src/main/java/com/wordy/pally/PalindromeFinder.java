package com.wordy.pally;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * A finder of palindromes in 'a man, a plan, a canal - Panama'!
 *
 * Finds top X length palindromes for a given String
 *
 */
public class PalindromeFinder {

    public List<Palindrome> find(String fyddycent, int i) {
        return new ArrayList<Palindrome>();
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
}
