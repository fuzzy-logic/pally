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
     * Use while parsing string or character arrays to flag second repeating letter in a given string
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
}
