class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s

        rows = [[] for _ in range(numRows)]
        k = 0
        direction = -1  # equivalent to (numRows == 1) - 1 in C++

        for c in s:
            rows[k].append(c)
            if k == 0 or k == numRows - 1:
                direction *= -1
            k += direction

        ans = ''.join([''.join(row) for row in rows])
        return ans
