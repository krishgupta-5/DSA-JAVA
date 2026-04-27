package Array;

public class SingleElementinaSortedArray {
    public static void main(String[] args) {
        int nums[] = {1,1,2,3,3,4,4,8,8};

        int left = 0,
            right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;

            int leftIdx = left - mid + 1;
            int rightIdx = right - mid + 1;

            if(nums[mid] == nums[mid + 1]){
                if(rightIdx % 2 == 0){
                    right = mid - 1;
                }
                else{
                    left = mid + 2;
                }
            }
            else if(nums[mid] == nums[mid - 1]){
                if(left % 2 == 0){
                    left = mid + 1;
                }
                else{
                    right = mid - 2;
                }
            }
        }
    }
}
