package com.wordy.pally;


import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;


public class PalindromeWordSearchTest {

    @Test
    public void testFindPalindromeAtIndex() {
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        List<Palindrome> results  = palindromeFinder.find("fyddycent", 1);
        assertNotNull(results);
    }

    @Test
    public void testIsRepeatCharacterAtIndex1() {
        String inputString = "abbawabba";
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        boolean isRepeat = palindromeFinder.isRepeatCharacterAtIndex(inputString.toCharArray(), 1);
        assertFalse(isRepeat);
    }

    @Test
    public void testIsRepeatCharacterAtIndex2() {
        String inputString = "abbawabba";
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        boolean isRepeat = palindromeFinder.isRepeatCharacterAtIndex(inputString.toCharArray(), 2);
        assertTrue(isRepeat);
    }

    @Test
    public void testIsRepeatCharacterOutOfBounds() {
        String inputString = "abbawabba";
        PalindromeFinder palindromeFinder = new PalindromeFinder();

        boolean isRepeat = palindromeFinder.isRepeatCharacterAtIndex(inputString.toCharArray(), 64);
        assertFalse(isRepeat);

        isRepeat = palindromeFinder.isRepeatCharacterAtIndex(inputString.toCharArray(), -1);
        assertFalse(isRepeat);

        isRepeat = palindromeFinder.isRepeatCharacterAtIndex(inputString.toCharArray(), 0);
        assertFalse(isRepeat);
    }

    @Test
    public void testGetNextMatchingCharPairWithTwoLetterPalindrome() {
        String inputString = "gg";
        PalindromeFinder palindromeFinder = new PalindromeFinder();

        char[] firstMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 1, 0);
        char[] secondMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 1, 1);

        assertArrayEquals(new char[]{'g', 'g'}, firstMatchingCharacters);
        assertNull(secondMatchingCharacters);

    }

    @Test
    public void testGetNextMatchingCharPairWithNonPalindrome() {
        String inputString = "ga";
        PalindromeFinder palindromeFinder = new PalindromeFinder();

        char[] firstMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 1, 0);

        assertNull(firstMatchingCharacters);

    }

    @Test
    public void testGetNextMatchingCharPairWithFourLetterPalindromeInSixLetterWord() {
        String inputString = "qabbaw";

        PalindromeFinder palindromeFinder = new PalindromeFinder();

        char[] firstMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 3, 0);
        char[] secondMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 3, 1);
        char[] thirdMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 3, 2);
        char[] fourthMatchingCharacters = palindromeFinder.getNextMatchingCharPair(inputString.toCharArray(), 3, 3);

        assertArrayEquals(new char[]{'b', 'b'}, firstMatchingCharacters);
        assertArrayEquals(new char[]{'a', 'a'}, secondMatchingCharacters);
        assertNull(thirdMatchingCharacters);
        assertNull(fourthMatchingCharacters);

    }

}
