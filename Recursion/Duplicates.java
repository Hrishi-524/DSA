package Recursion;

public class Duplicates {
    public static boolean isUnique(char ch, boolean map[]) {
        return !(map[ch-'a']);
    }

    public static void removeDuplicates1(StringBuilder text, StringBuilder res, int idx, boolean[] map) {
        if (idx == text.length()) {
            System.out.println(res);
            return;
        }

        char ch = text.charAt(idx);
        if (!map[ch - 'a']) {
            map[ch - 'a'] = true;
            res.append(ch);
        }

        removeDuplicates1(text, res, idx + 1, map);
    }

    public static StringBuilder removeDuplicates2(StringBuilder text, int idx, boolean[] map) {
    if (idx == text.length()) {
        return new StringBuilder("");
    }

    char ch = text.charAt(idx);
    StringBuilder rest = removeDuplicates2(text, idx + 1, map);

    if (!map[ch - 'a']) {
        map[ch - 'a'] = true;
        return new StringBuilder().append(ch).append(rest);
    } else {
        return rest;
    }
}

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("apnacollege");
        StringBuilder res = new StringBuilder("");
        boolean map[] = new boolean[26];
        removeDuplicates1(text, res, 0, map);
    }
}
