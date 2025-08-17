class Solution {
  public int romanToInt(String s) {
    int ans = 0;
    int[] roman = new int[128];

    roman['I'] = 1;
    roman['V'] = 5;
    roman['X'] = 10;
