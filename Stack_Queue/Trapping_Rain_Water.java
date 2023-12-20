package Stack_Queue;

public class Trapping_Rain_Water {

    public int solution(int arr[]) {

        int ans = 0, n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) 
            left[i] = Math.max(left[i - 1], arr[i]);
        
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        for (int i = 0; i < n; i++)
            ans += Math.min(left[i], right[i]) - arr[i];

        return ans;
    }

    public int trap(int[] arr) {

        // uses Time-O(n) and space-O(1).

        int ans = 0, n = arr.length;

        // Create two new arrays of Size n
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            ans +=Math.min(left[i], right[i]) - arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Trapping_Rain_Water ob = new Trapping_Rain_Water();
        int arr[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(ob.solution(arr));
        System.out.println(ob.trap(arr));
    }
}
