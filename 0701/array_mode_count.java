public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};

        int mode = arr[0];  
        int maxCount = 0;   

        for (int i = 0; i < arr.length; i++) {
            int count = 0; 
            
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}
//是否可以改善？
//可以。透過使用 HashMap 儲存每個元素的出現次數，可以將時間複雜度改善為 O(n)，因為只需遍歷陣列一次，更新 HashMap 的時間是 O(1)，而計算眾數也是 O(n)。

//改進後的方法：
//使用 HashMap 來記錄每個元素的出現次數。
//遍歷陣列一次，更新 HashMap。
//找出最大次數的元素。