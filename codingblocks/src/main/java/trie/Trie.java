package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// suffix trie implementatiion
public class Trie {
    private TrieNode root;

    Trie() {
        // sentinal root node
        root = new TrieNode('*');
    }


    public void insert(String word) {
        TrieNode temp = this.root;

        for (char c : word.toCharArray()) {
            if (!temp.chidlren.containsKey(c)) {
                TrieNode n = new TrieNode(c);
                temp.chidlren.put(c, n);
            }
            temp = temp.chidlren.get(c);
        }
        // last character
        temp.isTerminal = true;
    }

    public boolean search(String word) {
        TrieNode temp = this.root;

        for (char c : word.toCharArray()) {
            if (!temp.chidlren.containsKey(c)) {
                return false;
            }
            temp = temp.chidlren.get(c);
        }
        return temp.isTerminal;
    }

    static class TrieNode {
        char c;
        Map<Character, TrieNode> chidlren;
        boolean isTerminal;

        TrieNode(char c) {
            this.c = c;
            chidlren = new HashMap<>();
            isTerminal = false;
        }
    }

}

class TrieRunner {
    public static void main(String[] args) {
        String[] words = {"apple", "ape", "news", "not"};
        Trie t = new Trie();
        for (String w : words) {
            t.insert(w);
        }
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            String query = sc.next();
            if (t.search(query)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}
