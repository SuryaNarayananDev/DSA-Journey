class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+n];
        int i=0,j=(n+n)-1;
        while(i<=j){
            arr[i]=nums[i];
            arr[j]=nums[i];
            j--;
            i++;
        }
        return arr;

    }
}