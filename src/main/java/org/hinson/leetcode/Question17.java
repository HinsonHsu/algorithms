package org.hinson.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Question17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        Map<Character, List<Character>> characterListMap = new HashMap<>();
        characterListMap.put('2', new LinkedList<Character>() {{
            add('a');
            add('b');
            add('c');
        }});
        characterListMap.put('3', new LinkedList<Character>() {{
            add('d');
            add('e');
            add('f');
        }});
        characterListMap.put('4', new LinkedList<Character>() {{
            add('g');
            add('h');
            add('i');
        }});
        characterListMap.put('5', new LinkedList<Character>() {{
            add('j');
            add('k');
            add('l');
        }});
        characterListMap.put('6', new LinkedList<Character>() {{
            add('m');
            add('n');
            add('o');
        }});
        characterListMap.put('7', new LinkedList<Character>() {{
            add('p');
            add('q');
            add('r');
            add('s');
        }});
        characterListMap.put('8', new LinkedList<Character>() {{
            add('t');
            add('u');
            add('v');
        }});
        characterListMap.put('9', new LinkedList<Character>() {{
            add('w');
            add('x');
            add('y');
            add('z');
        }});

        StringBuffer sb = new StringBuffer();

        dfs(digits, 0, res, sb, characterListMap);
        return res;
    }

    private void dfs(String digits, int start, List<String> res, StringBuffer sb, Map<Character, List<Character>> map) {
        if (start == digits.length()) {
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
            return;
        }
        char c = digits.charAt(start);
        List<Character> characters = map.getOrDefault(c, new LinkedList<>());
        if (characters.isEmpty()) {
            dfs(digits, start + 1, res, sb, map);
        } else {
            for (int i = 0; i < characters.size(); i++) {
                char c1 = characters.get(i);
                sb.append(c1);
                dfs(digits, start + 1, res, sb, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = new Question17().letterCombinations("23");
        System.out.println(res);
    }
}