package org.hinson.sword;

import java.util.BitSet;

public class Q50 {

    public int firstNotRepeating(String str) {
        BitSet bitSet1 = new BitSet(128);
        BitSet bitSet2 = new BitSet(128);

        for (char c : str.toCharArray()) {
            if (!bitSet1.get(c) && !bitSet2.get(c)) {
                bitSet1.set(c);
            } else if (bitSet1.get(c) && !bitSet2.get(c)) {
                bitSet2.set(c);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bitSet1.get(c) && !bitSet2.get(c)) {
                return i;
            }
        }
        return -1;
    }
}
