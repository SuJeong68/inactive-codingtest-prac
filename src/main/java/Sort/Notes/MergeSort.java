package Sort.Notes;

public class MergeSort {
    public static void sort(int[] arr) {
        // 시간 복잡도 : O(nlogn)
        // PRE-CONDITION : 순서값의 시퀀스
        // POST-CONDITION : 전체 시퀀스 정렬
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int p, int q) {
        // sort(arr, p, q) 반복으로 divide
        // PRE-CONDITION : 0 <= p <= q <= arr.length
        // POST-CONDITION : arr[p..q) 정렬
        if (q - p < 2)
            return;

        int m = (p + q) / 2;
        sort(arr, p, m);
        sort(arr, m, q);
        merge(arr, p, m, q);
    }

    private static void merge(int[] arr, int p, int m, int q) {
        // PRE-CONDITION : 0 <= p <= m < q <= arr.length
        //                 arr[p..m) is sorted
        //                 arr[m..q) is sorted
        // POST-CONDITION : arr[p..q) 정렬
        if (arr[m - 1] <= arr[m])
            return;

        int i = p, j = m, idx = 0;
        int[] tmp = new int[q - p];
        // 양쪽으로 분할된 배열을 각자의 가장 앞부터 비교해 정렬
        while (i < m && j < q)
            tmp[idx++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        System.arraycopy(arr, i, arr, p + idx, m - i);
        System.arraycopy(tmp, 0, arr, p, idx);
    }

    public static void main(String[] args) {
        sort(new int[] { 453, 54561, 77, 4, 685, 123, 667, 57, 242348, 9768, 3 });
    }
}
