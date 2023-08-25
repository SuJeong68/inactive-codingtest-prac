package Sort.Notes;

public class QuickSort {
    public static void sort(int[] arr) {
        // 시간 복잡도 : O(nlogn)
        // 대부분의 경우 병합 정렬 (Merge sort)보다 빠름

        // PRE-CONDITION : 순서값의 시퀀스
        // POST-CONDITION : 전체 시퀀스 정렬
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int lo, int hi) {
        // PRE-CONDITION : 0 <= p <= q <= a.length
        // POST-CONDITION : a[p..q) 정렬
        if (hi - lo < 2)
            return;

        int m = partition(arr, lo, hi);
        sort(arr, lo, m);
        sort(arr, m + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        // 왼쪽 피벗 방식으로 구현
        // pivot 기준으로 왼쪽 오른쪽 나누기 위해 while 이용
        // POST-CONDITION : a[i] <= a[m] <= a[j] for p <= i <= m <= j < q;
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[--hi] >= pivot) {}
            if (lo < hi)
                arr[lo] = arr[hi];
            while (lo < hi && arr[++lo] <= pivot) {}
            if (lo < hi)
                arr[hi] = arr[lo];
        }
        arr[hi] = pivot;
        return hi;
    }

    public static void main(String[] args) {
        sort(new int[] { 9, 6, 7, 1, 5, 4, 8, 2, 3 });
    }
}
