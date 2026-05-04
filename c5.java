
class Solution {
    public List<List<String>> palindromePartition(String s) {
        //result list
        List<List<String>> res = new ArrayList<>();
        // current list
        List<String> current = new ArrayList<>();

        // recursion call 
        backtrack(s, 0, current, res);
        return res;

    }

    public void backtrack(String s, int index, List<String> current, List<List<String>> res) {
        // base case 
        if (index == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }
        //loop
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1); // inclusive yh i tak he jyga 
            if (isPalindrome(s, index, i)) {
                // we will add to the path
                current.add(sub);
                // now move to next spot we already sove this 
                backtrack(s, i + 1, current, res);
                // backtrack 
                current.remove(current.size() - 1);

            }

        }

    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
HEAD
// add my code justchecking branch works or not

// Time complexity: O(N*2^N) where N is the length of the string. In the worst case, we have to explore all possible partitions of the string, which can be 2^(N-1) (each character can either be a partition or not). Additionally, checking if a substring is a palindrome takes O(N) time in the worst case.
br2
