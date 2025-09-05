import java.util.*;

public class LC_CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

        
        List<List<Integer>> res = combinationSumSingleUse(candidates, target);

        for (List<Integer> comb : res) {
            for (int i = 0; i < comb.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(comb.get(i));
            }
            System.out.println();
        }
    }

    
    static List<List<Integer>> combinationSumUnlimited(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrackUnlimited(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    static void backtrackUnlimited(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) return;

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;  
            path.add(candidates[i]);
            backtrackUnlimited(candidates, remain - candidates[i], i, path, res);  
            path.remove(path.size() - 1);
        }
    }

    
    static List<List<Integer>> combinationSumSingleUse(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrackSingleUse(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    static void backtrackSingleUse(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) return;

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;  
            if (i > start && candidates[i] == candidates[i-1]) continue; 
            path.add(candidates[i]);
            backtrackSingleUse(candidates, remain - candidates[i], i + 1, path, res); 
            path.remove(path.size() - 1);
        }
    }
}
