package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_I {

    class Pair {
        String first;
        int second;

        Pair(String x, int y) {
            first = x;
            second = y;
        }
    }

    public int wordLadder(String start, String end, String[] list) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start,1));
        Set<String> s = new HashSet<>();
        for (int i = 0; i < list.length; i++)
            s.add(list[i]);
        s.remove(start);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(end))
                return steps;
            for (int i = 0; i < start.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordarray = word.toCharArray();
                    wordarray[i] = ch;
                    String wordString = new String(wordarray);
                    if (s.contains(wordString)) {
                        q.add(new Pair(wordString, steps + 1));
                        s.remove(wordString);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Word_Ladder_I ob = new Word_Ladder_I();
        String start = "hit", end = "cog";
        String wordList[] = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(ob.wordLadder(start, end, wordList));
    }
}
