package HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class Introduction {
    
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);

        // set.remove(3);
        // System.out.println(set.size());
        // System.out.println(set);

        //Iterator
        Iterator<Integer> it = set.iterator();
        // hasNext; next

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
