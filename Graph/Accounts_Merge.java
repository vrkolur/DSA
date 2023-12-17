package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts_Merge {

    public List<List<String>> accountMerge(List<List<String>> accounts) {

        int n = accounts.size();
        HashMap<String, Integer> map = new HashMap<>();
        DisjointSets ds = new DisjointSets(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail))
                    map.put(mail, i);
                else
                    ds.unionbyRank(i, map.get(mail));
            }
        }

        // ArrayList<String>[] mergedMail = new ArrayList[n];
        ArrayList<ArrayList<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++)
            mergedMail.add(new ArrayList<>());

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUltiParent(it.getValue());
            mergedMail.get(node).add(mail);
        }

        // System.out.println(mergedMail);

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0)
                continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMail.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Accounts_Merge ob = new Accounts_Merge();
        List<List<String>> accounts = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.addAll(Arrays.asList("John", "J1", "J2", "J3"));
        accounts.add(temp);
        List<String> temp1 = new ArrayList<>();
        temp1.addAll(Arrays.asList("John", "J4", "J5"));
        accounts.add(temp1);
        List<String> temp2 = new ArrayList<>();
        temp2.addAll(Arrays.asList("John", "J2", "J7"));
        accounts.add(temp2);
        // System.out.println(accounts);
        List<List<String>> res = ob.accountMerge(accounts);
        System.out.println(res);
    }
}
