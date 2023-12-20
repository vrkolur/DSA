package Greedy;

import java.util.HashSet;

// import java.util.Arrays;

public class Longest_Palindrome {

    // private void longestPalindrome(String str) {
    //     int[] arr = new int[123];
        // Arrays.fill(arr, -1);
    //     int n = str.length();
    //     for (int i = 0; i < n; i++) {
    //         arr[str.charAt(i) - '0']++;
    //     }
    //     int ans = 0;
    //     int max = Integer.MIN_VALUE;
    //     for (int i = 0; i < 123; i++) {
    //         if (arr[i] != 0 && arr[i] % 2 == 0) {
    //             ans += arr[i];
    //         }
    //         if (arr[i] != 0 && arr[i] % 2 == 1) {
                // System.out.println(arr[i]);
    //             max = Math.max(max, arr[i]);
    //         }
    //     } // System.out.println(arr['a'-'0']);
    //       //   for (int i = 0; i < 123; i++) {
    //       //       if (arr[i] != 0)
    //       //       System.out.print(arr[i]+" ");;
    //       //   }
    //     for (int i = 0; i < 123; i++) {
    //         if (arr[i] != 0 && arr[i] % 2 == 1 && arr[i] != max) {
    //             ans = ans + arr[i] - 1;
    //         }
    //     }
    //     // if (max < 0) {
    //     //     return ans;
    //     // } else
    //     //     return ans + max;
    // }
    
    private int longestPalindrome(String str) {
        HashSet<Character> set = new HashSet<Character>();
        int res=0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                res += 2;
                set.remove(ch);
            }
            else {
                set.add(ch);
            }
        }
        if (set.size() > 0)
            res++;
        return res;
    }

    public static void main(String[] args) {
        Longest_Palindrome ob = new Longest_Palindrome();
        String str = "bvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
        // System.out.println(str.length());
        // System.out.println(ob.longestPalindrome(str));
        // ob.longestPalindrome(str);
        System.out.println(ob.longestPalindrome(str));
    }
}
