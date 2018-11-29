package www.bit.java;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 */

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int m = 0;
        int n = 1;
        for(int i = 0; i < len; i++){
            if(A[i]%2 == 0){
                B[m] = A[i];
                m+=2;
            }else{
                B[n] = A[i];
                n+=2;
            }
        }
        return B;
    }
}

public class Practice18 {
    public static void main(String[] args) {
        int[] A = new int[]{4,2,5,7};
        Solution solution = new Solution();
        int[] B = solution.sortArrayByParityII(A);
        for(int x:B){
            System.out.print(x+"、");
        }
    }
}
