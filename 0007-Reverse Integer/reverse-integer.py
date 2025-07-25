class Solution:
    def reverse(self, x: int) -> int:
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        reversed_number = 0

        while x != 0:
            # Handle Python's lack of fixed-size integers
            pop = x % 10 if x > 0 else x % -10
            x = x // 10 if x > 0 else (x - pop) // 10

            if reversed_number < INT_MIN // 10 or reversed_number > INT_MAX // 10:
                return 0

            reversed_number = reversed_number * 10 + pop

        return reversed_number
