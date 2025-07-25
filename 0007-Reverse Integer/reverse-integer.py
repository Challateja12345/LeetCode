class Solution:
    def reverse(self, x: int) -> int:
        INT_MIN, INT_MAX = -2**31, 2**31 - 1

        sign = -1 if x < 0 else 1
        x = abs(x)
        reversed_number = 0

        while x != 0:
            digit = x % 10
            x //= 10

            # Check for overflow before multiplying/adding
            if reversed_number > (INT_MAX - digit) // 10:
                return 0

            reversed_number = reversed_number * 10 + digit

        return sign * reversed_number
