package Sort.Notes;

public class SelectionSort {
    public static void sort(int[] arr) {
        // 시간복잡도 : O(n^2)
        // 버블 정렬과 유사함. But, 가장 큰 수를 찾아 적절한 위치에 배치하기 때문에 보다 효율적!
        // POST-CONDITION : 전체 시퀀스 정렬
        for (int i = arr.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[max])
                    max = j;
            }
            swap(arr, i, max);
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
