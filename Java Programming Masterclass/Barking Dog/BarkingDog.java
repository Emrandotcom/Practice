public class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (barking && hourOfDay < 8 || barking && hourOfDay > 22) {
            if (hourOfDay < 0 || hourOfDay > 23)
                return false;
            else
                return true;
        }
        return false;
    }
}
