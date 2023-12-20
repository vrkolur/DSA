package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Sort_Array_Recursion {

    public List<Integer> sorting(List<Integer> arr) {
        if (arr.size() == 1)
            return arr;

        int temp = (int) arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        arr = sorting(arr);
        arr = insertion(arr, temp);
        return arr;
    }

    public List<Integer> insertion(List<Integer> arr, int temp) {
        if (arr.size()==0 || (int) arr.get(arr.size() - 1) <= temp) {
            arr.add(arr.size(), temp);
            return arr;
        }
        int temp1 = (int) arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        arr = insertion(arr, temp);
        arr.add(arr.size(), temp1);
        return arr;
    }

    public static void main(String[] args) {
        Sort_Array_Recursion ob = new Sort_Array_Recursion();
        int array[] = { 9,8,7,4,5,6,3,2,1 };
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arr.add(array[i]);
        }
        ob.sorting(arr);
        System.out.println(arr);
    }
}
