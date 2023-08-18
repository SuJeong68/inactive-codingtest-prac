package Sort.Notes;

public class InsertionSort {
    public static void sort(int[] arr) {
        // 시간복잡도 : O(n^2)
        // 요소 값을 임시로 들고, 비교 후 값들을 뒤로 밀어 정렬
        // POST-CONDITION : 전체 시퀀스 정렬
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
