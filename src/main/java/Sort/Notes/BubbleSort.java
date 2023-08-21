package Sort.Notes;

public class BubbleSort {
    public static void sort(int[] arr) {
        // 시간복잡도 : O(n^2)
        // PRE-CONDITION : 순서값의 시퀀스
        // POST-CONDITION : 전체 시퀀스 정렬
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // PRE-CONDITION : 0 <= i < arr.length && 0 <= j < arr.length
        // POST-CONDITION : arr[i] <-> arr[j] 변경
        if (i == j)
            return;

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
