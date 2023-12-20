package Sliding_Window;

public class Best_Time_to_Buy_and_Sell_Stock {
    
    private int solution(int[] arr) {
        int maxProfit = Integer.MIN_VALUE;
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if (arr[i] < arr[j])
                maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
            else 
                i = j;
            j++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock ob = new Best_Time_to_Buy_and_Sell_Stock();
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(ob.solution(prices));
    }
}
