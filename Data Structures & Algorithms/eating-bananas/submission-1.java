class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int soFar = Integer.MAX_VALUE;
        return minEatingSpeed(piles, h, 1, max, soFar);

    }

    private int minEatingSpeed(int[] piles, int h, int lo, int hi, int soFar) {
        if (lo > hi) {   
            return soFar;
        }
        int mid = lo + ((hi - lo) / 2);
        int rightNow = 0;
        for (int i = 0; i < piles.length; i++) {
            rightNow += Math.ceil((double)piles[i] / mid);
        }
        if (rightNow <= h) {   
            soFar = Math.min(soFar, mid);
            return minEatingSpeed(piles, h, lo, mid - 1, soFar);
        } else {
            return minEatingSpeed(piles, h, mid + 1, hi, soFar);
        }

    }


}
