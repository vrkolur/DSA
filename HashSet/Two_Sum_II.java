package HashSet;

public class Two_Sum_II {
    private int[] solution(int[] arr, int key) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == key)
                return new int[] { i, j };
            else if (sum > key)
                j--;
            else
                i++;
        }
        return new int[] { -1, -1 };
    }
    
    public static void main(String[] args) {
        Two_Sum_II ob = new Two_Sum_II();
        int arr[] = { -1,0 };
        int key = -1;
        int[] res = ob.solution(arr, key);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
