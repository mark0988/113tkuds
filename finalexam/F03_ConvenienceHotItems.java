import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        
        List<Item> items = new ArrayList<>();
        
        
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int qty = scanner.nextInt();
            items.add(new Item(name, qty));
        }
        
       
        insertionSort(items);
        
       
        for (int i = 0; i < Math.min(10, items.size()); i++) {
            Item item = items.get(i);
            System.out.println(item.name + " " + item.qty);
        }
        
        scanner.close();
    }
    
    
    private static void insertionSort(List<Item> items) {
        for (int i = 1; i < items.size(); i++) {
            Item currentItem = items.get(i);
            int j = i - 1;
            
            
            while (j >= 0 && (items.get(j).qty < currentItem.qty || 
                              (items.get(j).qty == currentItem.qty && items.get(j).name.compareTo(currentItem.name) > 0))) {
                items.set(j + 1, items.get(j)); 
                j--;
            }
            items.set(j + 1, currentItem); 
        }
    }
    
    
    static class Item {
        String name;
        int qty;
        
        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }
}
// 計算複雜度分析：
// 1. 讀取商品名稱和銷量的過程是 O(n)，因為我們需要讀取 n 行輸入。
// 2. 插入排序的時間複雜度是 O(n^2)，這是最壞情況的複雜度，特別是當數據完全反向排序時。
//    - 在插入排序中，每個元素都會與已排序的部分進行比較並插入，最壞情況下需要進行 n 次比較。
// 3. 輸出最多 10 行結果是 O(10)，即 O(1)，不會影響總的複雜度。
// 因此，整個程式的時間複雜度為 O(n^2)，其中 n 是商品的數量。
// 空間複雜度是 O(n)，因為我們使用了 List 來存儲商品。
