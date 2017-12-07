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
}
