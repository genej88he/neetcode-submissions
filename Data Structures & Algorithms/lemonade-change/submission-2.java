class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] possibleBills = new int[3];
        for (int i = 0; i < bills.length; i++) {  
            if (bills[i] == 5) {
                possibleBills[0]++;
            } else if (bills[i] == 10) {
                possibleBills[1]++;
                if (possibleBills[0] == 0) {
                    return false;
                } else {
                    possibleBills[0]--;
                }
            } else {
                possibleBills[2]++;
                if (possibleBills[1] == 0 && possibleBills[0] < 3) {
                    return false;
                }
                if (possibleBills[1] != 0 && possibleBills[0] == 0) {
                    return false;
                }
                
                if (possibleBills[1] == 0) {
                    possibleBills[0] -= 3;
                } else {
                    possibleBills[0]--;
                    possibleBills[1]--;
                }
            }
        }
        return true;
    }
}