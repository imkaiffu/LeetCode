class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prevDevices = 0;

        for (String row : bank) {
            int currDevices = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    currDevices++;
                }
            }
            if (currDevices > 0) {
                totalBeams += prevDevices * currDevices;
                prevDevices = currDevices;
            }
        }

        return totalBeams;
    }
}