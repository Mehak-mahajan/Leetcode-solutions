
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
