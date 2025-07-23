class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(); // Get the length of the string.
        boolean[][] dp = new boolean[n][n]; // Create a dynamic programming (DP) table.
      
        // Initialize all substrings of length 1 (single character) as a palindrome.
        for (boolean[] row : dp) {
            Arrays.fill(row, true);
        }
      
        int startIdx = 0; // Starting index of the longest palindromic substring found.
        int maxLength = 1; // Length of the longest palindromic substring found, initialized with length 1.
      
        // Build the DP table in a bottom-up manner.
        for (int i = n - 2; i >= 0; --i) { // Start from the second last character and move backwards.
            for (int j = i + 1; j < n; ++j) { // Compare it with characters ahead of it.
                dp[i][j] = false; // Initialize the current substring (i, j) as not palindrome.
                if (s.charAt(i) == s.charAt(j)) { // If the characters match,
                    dp[i][j] = dp[i + 1][j - 1]; // Check if removing them gives a palindrome.
                    // Update the start position and max length if a larger palindrome is found.
                    if (dp[i][j] && maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }
      
        // Extract the longest palindromic substring from the string.
        return s.substring(startIdx, startIdx + maxLength);
    }
}
