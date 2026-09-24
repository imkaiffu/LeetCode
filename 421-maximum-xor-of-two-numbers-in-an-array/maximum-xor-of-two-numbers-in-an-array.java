class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        for (int num : nums) {
            TrieNode current = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (current.children[bit] == null) {
                    current.children[bit] = new TrieNode();
                }
                current = current.children[bit];
            }
        }

        int maxXor = 0;

        for (int num : nums) {
            TrieNode current = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit;

                if (current.children[oppositeBit] != null) {
                    currentXor |= (1 << i);
                    current = current.children[oppositeBit];
                } else {
                    current = current.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}