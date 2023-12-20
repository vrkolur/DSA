package HashSet;
import java.util.HashMap;
public class Intro_Hashmap {
    
    public static void main(String[] args) {
        // country -key; popolation-value

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("USA", 30);
        map.put("China", 150);

        // System.out.println(map);
        
        // map.put("India", 150);
        // System.out.println(map);

        System.out.println(map.get("India"));
        System.out.println(map.containsKey("India"));

    }
}
