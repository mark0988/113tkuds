import java.util.*;

public class M03_TopKConvenience {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int k = sc.nextInt(); 

        
        class Product {
            String name;
            int qty;

            Product(String name, int qty) {
                this.name = name;
                this.qty = qty;
            }
        }

       
        PriorityQueue<Product> minHeap = new PriorityQueue<>(k, (a, b) -> {
            if (a.qty != b.qty) {
                return Integer.compare(a.qty, b.qty); 
            } else {
                return a.name.compareTo(b.name); 
            }
        });

        
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            Product p = new Product(name, qty);

            if (minHeap.size() < k) {
                minHeap.offer(p); 
            } else {
                Product top = minHeap.peek();
                if (p.qty > top.qty || (p.qty == top.qty && p.name.compareTo(top.name) < 0)) {
                    minHeap.poll();     
                    minHeap.offer(p);   
                }
                
            }
        }

        
        List<Product> result = new ArrayList<>(minHeap);
        result.sort((a, b) -> {
            if (b.qty != a.qty) {
                return Integer.compare(b.qty, a.qty); 
            } else {
                return a.name.compareTo(b.name); 
            }
        });

        
        for (Product p : result) {
            System.out.println(p.name + " " + p.qty);
        }
    }
}
