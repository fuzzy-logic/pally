package com.wordy.pally;

/**
 * DTO 'value object' for discovered palindrome results
 *
 */

public class Palindrome  {

    String text;
    int index;
    int length;

    public Palindrome(String word, int index, int length) {
        this.text = word;
        this.index = index;
        this.length = length;
    }

    public String text() {
        return text;
    }

    public Integer index() {
        return index;
    }

    public Integer length() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Text: ").append(text).append(", index: ").append(index).append(", length: ").append(length).toString();
    }

}
