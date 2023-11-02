package org.hinson.sword;

public class Q58_1 {

    public String reverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();

        int i = 0, j = 0;

        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverseChars(chars, i, j);
                i = j + 1;
            }
            j++;
        }
        return new String(chars);
    }


    private void reverseChars(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
