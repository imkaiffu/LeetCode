import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(arr[a[0]] * arr[b[1]], arr[b[0]] * arr[a[1]])
        );

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new int[]{i, n - 1});
        }

        while (k > 1) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];

            if (j - 1 > i) {
                pq.offer(new int[]{i, j - 1});
            }
            k--;
        }

        int[] result = pq.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}