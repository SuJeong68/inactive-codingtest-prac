package Sort.Notes;

public class HeapSort {
    public static void sort(int[] arr) {
        // 시간 복잡도 : O(nlogn)
        // Heap = 완전이진트리, 우선순위 큐를 위해 만들어진 자료구조(?) / 최대, 최소

        // PRE-CONDITION : 순서값의 시퀀스
        // POST-CONDITION : a[0] <= a[1] <= ... <= a[a.length-1]
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);


        for(int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int i, int j) {
        int tmp = arr[i];
        while (2 * i + 1 < j) {
            int k = 2 * i + 1;
            if (k + 1 < j && arr[k + 1] > arr[k])
                ++k;
            if (tmp >= arr[k])
                break;
            arr[i] = arr[k];
            i = k;
        }
        arr[i] = tmp;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        sort(new int[] { 55, 33, 88, 99, 77, 33, 44, 66, 44 });
    }
}
