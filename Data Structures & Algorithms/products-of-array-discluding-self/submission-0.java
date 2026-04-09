class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int total = 1;
        int numZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                total *= nums[i];
            }
        
            if (nums[i] == 0) {
                numZero++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (numZero == 0) {
                prefix[i] = total / nums[i];
            } else if (numZero > 1) {
                prefix[i] = 0;
            } else {
                if (nums[i] == 0) {
                    prefix[i] = total;
                    
                } else {
                    nums[i] = 0;
                }
            }
            
        }

        
        return prefix;
    }
}  
