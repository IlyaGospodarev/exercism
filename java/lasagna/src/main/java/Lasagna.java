public class Lasagna {

    public static final int MINOVER = 40;
    public static final int MINLAYERCOOKING = 2;
  
    public int expectedMinutesInOven(){
        return MINOVER;
    }

    public int remainingMinutesInOven(int min){
        return MINOVER - min;
    }

    public int preparationTimeInMinutes(int layer){
        return layer * MINLAYERCOOKING;
    }

    public int totalTimeInMinutes(int layer, int min){
        return min + layer * MINLAYERCOOKING;
    }
}
