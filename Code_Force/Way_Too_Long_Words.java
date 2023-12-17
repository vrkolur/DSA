package Code_Force;

import java.util.Scanner;

public class Way_Too_Long_Words {
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String str = cin.next();
            if (str.length() <= 10) {
                res[i] = str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(0));
                sb.append(str.length() - 2);
                sb.append(str.charAt(str.length() - 1));
                res[i] = sb.toString();
            }
        }
        for (String st : res) {
            System.out.println(st);
        }
        cin.close();
    }
}
