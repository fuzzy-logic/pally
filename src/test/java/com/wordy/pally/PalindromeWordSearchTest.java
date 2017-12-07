package com.wordy.pally;


import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class PalindromeWordSearchTest {

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

    @Test
    public void testFindPalindromeAtIndex() {
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        Palindrome palindrome = palindromeFinder.findPalindromeFromIndex("fyddycent".toCharArray(), 3);
        assertEquals("yddy", palindrome.text());
        assertEquals(1, palindrome.index().intValue());
        assertEquals(4, palindrome.length().intValue());
    }

    @Test
    public void testFindsOverlappingPalindromes() {
        PalindromeFinder palindromeFinder = new PalindromeFinder();   //012345678
        List<Palindrome> results = palindromeFinder.find("aabbaaaabb", 2);

        assertEquals(2, results.size());

        assertEquals("bbaaaabb", results.get(0).text());
        assertEquals(2, results.get(0).index().intValue());
        assertEquals(8, results.get(0).length().intValue());

        assertEquals("aabbaa", results.get(1).text());
        assertEquals(0, results.get(1).index().intValue());
        assertEquals(6, results.get(1).length().intValue());
    }

    /**
     * Test proving "coding challenge" input string case
     */
    @Test
    public void testDoesFindCodingChallengePlaindromes() {
        String inputString = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";
        PalindromeFinder palindrome = new PalindromeFinder();
        List<Palindrome> results = palindrome.find(inputString, 3);

        assertEquals(3, results.size());

        assertEquals("hijkllkjih", results.get(0).text());
        assertEquals(23, results.get(0).index().intValue());
        assertEquals(10, results.get(0).length().intValue());

        assertEquals("defggfed", results.get(1).text());
        assertEquals(13, results.get(1).index().intValue());
        assertEquals(8, results.get(1).length().intValue());

        assertEquals("abccba", results.get(2).text());
        assertEquals(5, results.get(2).index().intValue());
        assertEquals(6, results.get(2).length().intValue());
    }

}
