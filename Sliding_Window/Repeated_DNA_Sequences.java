package Sliding_Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repeated_DNA_Sequences {

    public List<String> solution(String s) {
        List<String> output = new ArrayList<>();

        Map<String, Integer> seen = new HashMap<>();

        
        if (s.length() == 10) {
            output.add(s);
        }
        int i = 0;
        while (i + 10 < s.length()) {
            String subSeq = s.substring(i, i++ + 10);
            seen.put(subSeq, seen.getOrDefault(subSeq, 0) + 1);
            if (seen.get(subSeq) == 2)
                output.add(subSeq);
        }

        return output;
    }
    


    public static void main(String[] args) {
        Repeated_DNA_Sequences ob = new Repeated_DNA_Sequences();
        // String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s1 = "AAAAAAAAAAAA";
        System.out.println(s1.length());
        System.out.println(ob.solution(s1));
    }
}
