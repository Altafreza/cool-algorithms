package queue;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * First non-repeating character in a stream of characters
 * Given a string A denoting a stream of lowercase alphabets. You have to make new string B.
 * B is formed such that we have to find first non-repeating character each time a character
 * is inserted to the stream and append it at the end to B. if no non-repeating character is found
 * then append '#' at the end of B.
 */
public class UniqueCharsInStream {


    public static void main(String[] args) {
        Queue<Character> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] cnt = new int[26];
        char x = sc.next().charAt(0);
        while (x != '.') {
            cnt[x - 'a']++;

            // no need to add dup char in queue if you have to remove it
            if (cnt[x - 'a'] == 1)
                q.add(x);

            // we check if the q contains an already seen ele with the help of a bit map
            // get rid of all such ele and find a fresh ele to build your solution with
            while (!q.isEmpty() && cnt[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (!q.isEmpty()) // we have a uniq ele until this point in the stresm
                out.println(q.peek());
            else
                out.println("#");
            out.flush();

            x = sc.next().charAt(0);

        }
        out.flush();
    }
}
