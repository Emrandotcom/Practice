public class EqualSumChecker {
    public static boolean hasEqualSum(int num1, int num2,int num3){

        int sum1And2 = num1 + num2;
        if (sum1And2 == num3){
            return true;
        } else
            return false;
    }
}
