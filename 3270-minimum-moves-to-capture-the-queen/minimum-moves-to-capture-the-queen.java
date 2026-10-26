class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != e || d <= Math.min(b, f) || d >= Math.max(b, f))) {
            return 1;
        }
        if (b == f && (d != f || c <= Math.min(a, e) || c >= Math.max(a, e))) {
            return 1;
        }
        if (Math.abs(c - e) == Math.abs(d - f) && (Math.abs(a - e) != Math.abs(b - f) || Math.abs(c - a) != Math.abs(d - b) || a <= Math.min(c, e) || a >= Math.max(c, e) || b <= Math.min(d, f) || b >= Math.max(d, f))) {
            return 1;
        }
        return 2;
    }
}