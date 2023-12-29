package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    private int[] twoSum(int[] nums,int target){
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-target)){
                res[0]=map.get(nums[i]-target);
                res[1]=i;
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Two_Sum ob=new Two_Sum();
        int[] nums={2,7,11,15};
        int target=9;
        int[] res=ob.twoSum(nums, target);
        System.out.println(res[0]+" "+res[1]);
    }
}
