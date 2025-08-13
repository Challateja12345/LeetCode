#include <climits>
#include <string>

class Solution {
public:
    /**
     * Converts the string argument to an integer (32-bit signed integer).
     * Trims whitespace, manages sign, and processes characters until a non-digit is found,
     * or the number goes out of the 32-bit signed integer range.
     * 
     * @param s - the string to convert to an integer.
     * @return The parsed integer, or 0 if no conversion is possible.
     */
    int myAtoi(std::string s) {
        // Trim leading whitespace
        size_t start = s.find_first_not_of(" \t\n\r");
        if (start == std::string::npos) return 0;  // Return 0 if the string is just whitespace
      
        s = s.substr(start);  // Trim leading whitespace
      
        bool isPositive = true;  // Flag indicating if the number is positive
        int i = 0;              // Index for iteration
        int answer = 0;         // Variable to accumulate the parsed number
      
        // Check if there is a sign in the beginning
        if (s[i] == '+') {
            isPositive = true;  // Positive number
            ++i;
        } else if (s[i] == '-') {
            isPositive = false; // Negative number
            ++i;
        }
      
        // Process each character in the string
        for (; i < s.length(); ++i) {
            // Calculate the numeric value of the current character
            int currentValue = s[i] - '0';
          
            // Break the loop if the character is not a digit
            if (currentValue < 0 || currentValue > 9) break;
          
            // Check for overflow: if the current answer is already at the risk of overflow
            // with an additional digit, return the respective limit
            if (answer > INT_MAX / 10 ||
                (answer == INT_MAX / 10 && currentValue > INT_MAX % 10)) {
                return isPositive ? INT_MAX : INT_MIN;
            }
          
            // Update the answer by adding the current digit
            answer = answer * 10 + currentValue;
        }
      
        // Return the final answer, considering the sign
        return isPositive ? answer : -answer;
    }
};
