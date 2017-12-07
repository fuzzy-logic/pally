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

}
