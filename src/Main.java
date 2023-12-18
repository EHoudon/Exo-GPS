import java.util.ArrayList;
import java.util.List;

public class Main {
    static double[][] list = {
            {45.171112, 5.695952},
            {45.183152, 5.699386},
            {45.174115, 5.711106},
            {45.176123, 5.722083},
            {45.184301, 5.719791},
            {45.184252, 5.730698},
            {45.170588, 5.716664},
            {45.193702, 5.691028},
            {45.165641, 5.739938},
            {45.178718, 5.744940},
            {45.176857, 5.762518},
            {45.188512, 5.767172},
            {45.174017, 5.706729},
            {45.174458, 5.687902},
            {45.185110, 5.733667},
            {45.185702, 5.734507},
            {45.184726, 5.734666},
            {45.184438, 5.733735},
            {45.184902, 5.735256},
            {45.174812, 5.698095},
            {45.169851, 5.695723},
            {45.180943, 5.698965},
            {45.176205, 5.692165},
            {45.171244, 5.689872}
    };

    public static void main(String[] args) {
        System.out.println(calculateDistance(list[0][0], list[0][1], list[1][0], list[1][1]));
        System.out.println(list[0][0]);
        System.out.println(list[0][1]);
        System.out.println(list[1][0]);
        System.out.println(list[1][1]);
        System.out.println(list.length);

        AllDistances();
    }

    private static Double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        return (Math.sqrt(x * x + y * y) * 6371);
    }

    private static void AllDistances() {
        ArrayList<Double> list2 = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                list2.add(calculateDistance(list[i][0], list[i][1], list[j][0], list[j][1]));
            }
        }
//        System.out.println(list2);
//        ArrayList<List<Double>> list3 = null;
//        for (int k = 0; k < list.length; k = k + 24) {
//            list3 = new ArrayList<>();
//            list3.add(list2.subList(k, k + 24));
//
//        }
//        System.out.println(list3);


    }
//    private static void AllDistances2(){
//
//    }

}










