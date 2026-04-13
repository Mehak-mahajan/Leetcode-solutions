import java.util.*;

class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int z = 0, o = 0;

        int[] p = new int[n + 1];
        Map<Integer, List<Integer>> mp = new HashMap<>();

        mp.put(0, new ArrayList<>());
        mp.get(0).add(0);

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '1') {
                p[i + 1] = p[i] + 1;
                o++;
            } else {
                p[i + 1] = p[i] - 1;
                z++;
            }

            mp.putIfAbsent(p[i + 1], new ArrayList<>());
            mp.get(p[i + 1]).add(i + 1);
        }

        // helper function equivalent
        java.util.function.BiFunction<Integer, Integer, Integer> solve = (t, lim) -> {

            int ans = 0;

            for (int r = 0; r <= n; r++) {

                int need = p[r] - t;

                if (!mp.containsKey(need))
                    continue;

                List<Integer> v = mp.get(need);

                int idx = lowerBound(v, r - lim);

                if (idx < v.size() && v.get(idx) < r) {
                    ans = Math.max(ans, r - v.get(idx));
                }
            }

            return ans;
        };

        return Math.max(
                Math.max(
                        solve.apply(0, n),
                        solve.apply(2, 2 * z)),
                solve.apply(-2, 2 * o));
    }

    // manual lower_bound (like C++)
    private int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();

        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
