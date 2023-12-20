package Sliding_Window;

import java.util.HashMap;

// using namespace std;int main(){string s="totmtaptat";string s1="tta";
// // Making the Map

// unordered_map<char,int>mp;for(int i=0;i<s1.length())mp[s1[i]]++;

// //Creating Variables

// int ans=INT_MAX;int i=0,j=0;int count=mp.size();

// // starting to  solve

// while(j<s.length()){
// // CALCULATION STEP ( As Aditya's general format)

// if(mp.find(s[j])!=mp.end())
// {mp[s[j]]--;
// if(mp[s[j]]==0)
// count--;}

// // step to slide " j "

// if(count>0)
// j++;

// // while(count==0)
// {if(mp.find(s[i])==mp.end()){i++;ans=min(ans,j-i+1); // updating the answer
// }else{mp[s[i]]++;if(mp[s[i]]>0){i++;count++;}else{i++;ans=min(ans,j-i+1);}}}j++;}}cout<<ans<<endl;return 0;}

// // step where we will find a candidate for answer

// else if(count==0)
// {ans=min(ans,j-i+1); // A candidate for our Answer

// // trying to minimize the window size after getting a candidate for answer

// while(count==0){if(mp.find(s[i])==mp.end()){i++;ans=min(ans,j-i+1); // updating the answer
// }else{mp[s[i]]++;if(mp[s[i]]>0){i++;count++;}else{i++;ans=min(ans,j-i+1); // updating the answer
// }}}j++;}}cout<<ans<<endl;return 0;}

public class Minimum_Window_Substring {

    private String solution1(String s, String t) {

        String ans = "";
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int count = map.size();

        while (j < s.length()) {

            char c = s.charAt(j);

            if (!map.containsKey(c)) {
                j++;
                continue;
            } else if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    count--;
            }

            if (count == 0) {
                if (min > j - i + 1) {
                    ans = s.substring(i, j + 1);
                    min = Math.min(min, j - i + 1);
                }
                while (count == 0) {
                    char c1 = s.charAt(i);
                    if (!map.containsKey(c1))
                        i++;
                    else {
                        map.put(c1, map.get(c1) + 1);
                        if (map.get(c1) > 0)
                            count++;
                        i++;
                    }
                    if (count == 0) {
                        if (min > j - i + 1) {
                            ans = s.substring(i, j + 1);
                            min = j - i + 1;
                        }
                    }
                }
            }
            j++;
        }
        return ans;
    }

    private String solution3(String s, String t) {

        if (t.length() > s.length())
            return "";

        int counter = 0;

        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            if (map[c]++ == 0)
                counter++;
        }

        int begin = 0, end = 0, head = 0;
        int len = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end++);
            if (--map[c] == 0)
                counter--;
            while (counter == 0) {
                char tmp = s.charAt(begin);
                if (++map[tmp] > 0)
                    counter++;
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        return (len == Integer.MAX_VALUE) ? "" : s.substring(head, head + len);
    }

    public static void main(String[] args) {
        Minimum_Window_Substring ob = new Minimum_Window_Substring();
        String s = "TOTMTAPTAT";
        String t = "TTA";
        System.out.println(ob.solution1(s, t));
        System.out.println();
        System.out.println(ob.solution3(s, t));
    }
}
