class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] possibleBills = new int[3];
        for (int i = 0; i < bills.length; i++) {
            int thisNumFives = bills[i] / 5;
            System.out.println(thisNumFives);    
            if (thisNumFives == 1) {
                possibleBills[0]++;
            } else if (thisNumFives == 2) {
                possibleBills[1]++;
                if (possibleBills[0] == 0) {
                    System.out.println("Error is here");
                    return false;
                } else {
                    possibleBills[0]--;
                }
            } else {
                possibleBills[2]++;
                if (possibleBills[1] == 0 && possibleBills[0] < 3) {
                    System.out.println("Error is here 2" + i);
                    return false;
                }
                if (possibleBills[1] != 0 && possibleBills[0] == 0) {
                    System.out.println("Error is here 3");
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