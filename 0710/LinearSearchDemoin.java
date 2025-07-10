import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchDemoin {
    static int linearSearch(int[] array, int target) {
        int comparisons = 0;
        
        for (int i = 0; i < array.length; i++) {
            comparisons++;
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n", 
                              comparisons, i, array[i], target);
            
            if (array[i] == target) {
                System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                return i;
            }
        }
        
        System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
        return -1;
    }

    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        
        if (count == 0) {
            return new int[0];
        }
        
        int[] result = new int[count];
        int resultIndex = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[resultIndex++] = i;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 僅改這兩行，其餘不動
        int[] numbers = new int[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        // 以下程式碼維持原樣
        System.out.println("\n陣列內容：" + Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
        System.out.println();

        System.out.println("=== 基本線性搜尋 ===");
        int result = linearSearch(numbers, target);
        
        if (result != -1) {
            System.out.printf("在索引位置 %d 找到目標值 %d\n", result, target);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }
        
        System.out.println("\n=== 搜尋所有符合位置 ===");
        int[] allPositions = linearSearchAll(numbers, target);
        
        if (allPositions.length > 0) {
            System.out.printf("目標值 %d 出現在以下位置：", target);
            for (int i = 0; i < allPositions.length; i++) {
                System.out.print(allPositions[i]);
                if (i < allPositions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf("\n總共出現 %d 次\n", allPositions.length);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }

        sc.close();
    }
}