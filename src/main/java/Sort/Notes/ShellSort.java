package Sort.Notes;

public class ShellSort {
    public static void sort(int[] arr) {
        // 시간복잡도 : O(n^1.5)
        // 특정 간격으로 스킵된 서브 시퀀스 생성 후 부분적으로 삽입 정렬
        // 아래의 구현 방법은 Knuth 공식 사용

        // PRE-CONDITION : 순서값의 시퀀스
        // POST-CONDITION : 전체 시퀀스 정렬
        int gap = 1, n = arr.length;
        while (9 * gap < n)
            gap = 3 * gap + 1;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j-gap] > temp) {
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 3;
        }
    }

    public static void shellSort(int[] arr) {
        // Ciura 공식 = 많이 쓰이는 공식 / Knuth 공식보다 효율적
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i], j;
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
        }
    }

    public static void main(String[] args) {
        shellSort(new int[] { 12, 1, 8, 11, 6, 2, 5, 9, 3, 10, 7, 4, 13, 16, 15, 14 });
    }
}
